package com.angeasla.ai_labor_rights_guide.ratelimit;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import io.github.bucket4j.Bandwidth;
import io.github.bucket4j.Bucket;
import io.github.bucket4j.ConsumptionProbe;
import org.springframework.stereotype.Service;

import java.net.InetAddress;
import java.time.Duration;
import java.util.List;
import java.util.Objects;

/**
 * In-memory per-IP token-bucket rate limiting (bucket4j). Single-node only — buckets live in this
 * JVM's heap; behind one nginx that is exactly right and needs no distributed store. Buckets are held
 * in bounded, self-evicting Caffeine caches (cap + expire-after-access) so the IP map cannot grow
 * without limit over a long-running deployment.
 *
 * <ul>
 *   <li><b>Chat</b> (expensive LLM calls): a short-term bucket enforces the per-minute burst + the
 *       hourly ceiling; a separate daily bucket enforces the 300/day quota. Exceeding the daily quota
 *       puts the IP in a cooldown "penalty box" for {@code chat.block-duration} and fires one alert.
 *       The cooldown is temporary and recurs while abuse continues — it is never a permanent ban.</li>
 *   <li><b>Search</b> (cheap, CPU-bound): a single per-minute bucket.</li>
 *   <li><b>Shared IPs</b> (VPN/NAT CIDRs): every limit is multiplied by {@code shared-multiplier}.</li>
 * </ul>
 */
@Service
public class RateLimitingService {

    /** Outcome of a check: whether to allow, and if not, how long to wait and what to tell the user. */
    public record Decision(boolean allowed, long retryAfterSeconds, String message) {
        static final Decision ALLOW = new Decision(true, 0, null);
    }

    // User-facing 429 messages (Greek). The transient one is the wording requested by the product.
    private static final String MSG_SLOW_DOWN  = "Περιμένετε λίγο πριν στείλετε νέο μήνυμα.";
    private static final String MSG_DAILY_BLOCK = "Υπερβήκατε το ημερήσιο όριο μηνυμάτων. Δοκιμάστε ξανά αργότερα.";
    private static final String MSG_SEARCH_BUSY = "Πάρα πολλές αναζητήσεις. Δοκιμάστε ξανά σε λίγο.";

    /** Hard ceiling on tracked IPs per cache (bounds memory; LRU-evicts the rest). */
    private static final long MAX_TRACKED_IPS = 100_000;

    private final RateLimitProperties props;
    private final AlertService alerts;
    private final List<CidrMatcher> sharedRanges;
    private final List<CidrMatcher> trustedProxyRanges;

    private final Cache<String, Bucket> chatShortTerm;
    private final Cache<String, Bucket> chatDaily;
    private final Cache<String, Bucket> searchBuckets;
    /** IP -> epoch-millis until which chat is blocked (daily-quota cooldown). */
    private final Cache<String, Long> chatBlockedUntil;

    public RateLimitingService(RateLimitProperties props, AlertService alerts) {
        this.props = props;
        this.alerts = alerts;
        this.sharedRanges = parseCidrs(props.getSharedCidrs());
        this.trustedProxyRanges = parseCidrs(props.getTrustedProxies());

        // expire-after-access ≥ the relevant window so an idle IP's state is dropped (a fresh bucket =
        // full tokens anyway), bounding memory. The cooldown cache outlives one block duration.
        this.chatShortTerm = Caffeine.newBuilder()
                .maximumSize(MAX_TRACKED_IPS).expireAfterAccess(Duration.ofHours(2)).build();
        this.chatDaily = Caffeine.newBuilder()
                .maximumSize(MAX_TRACKED_IPS).expireAfterAccess(Duration.ofHours(26)).build();
        this.searchBuckets = Caffeine.newBuilder()
                .maximumSize(MAX_TRACKED_IPS).expireAfterAccess(Duration.ofMinutes(5)).build();
        this.chatBlockedUntil = Caffeine.newBuilder()
                .maximumSize(MAX_TRACKED_IPS)
                .expireAfterWrite(props.getChat().getBlockDuration().plusHours(1)).build();
    }

    private static List<CidrMatcher> parseCidrs(List<String> cidrs) {
        return cidrs.stream()
                .filter(s -> s != null && !s.isBlank())
                .map(CidrMatcher::parse)
                .filter(Objects::nonNull)
                .toList();
    }

    public Decision checkChat(String ip) {
        if (!props.isEnabled()) {
            return Decision.ALLOW;
        }
        long now = System.currentTimeMillis();

        // 1) Already in cooldown? Reject without touching the buckets so they refill untouched.
        Long blockedUntil = chatBlockedUntil.getIfPresent(ip);
        if (blockedUntil != null && blockedUntil > now) {
            return new Decision(false, secondsUntil(blockedUntil, now), MSG_DAILY_BLOCK);
        }

        double mult = multiplierFor(ip);

        // 2) Short-term: per-minute burst + per-hour. Common case for casual over-use -> transient 429.
        ConsumptionProbe shortTerm = chatShortTerm.get(ip, k -> buildChatShortTerm(mult))
                .tryConsumeAndReturnRemaining(1);
        if (!shortTerm.isConsumed()) {
            return new Decision(false, secondsFromNanos(shortTerm.getNanosToWaitForRefill()), MSG_SLOW_DOWN);
        }

        // 3) Daily quota. Exhausting it is the abuse signal -> cooldown + alert (not a ban).
        long dailyCap = scale(props.getChat().getPerDay(), mult);
        if (!chatDaily.get(ip, k -> buildChatDaily(mult)).tryConsume(1)) {
            long cooldownSeconds = props.getChat().getBlockDuration().toSeconds();
            chatBlockedUntil.put(ip, now + props.getChat().getBlockDuration().toMillis());
            alerts.chatDailyCapExceeded(ip, dailyCap, cooldownSeconds);
            return new Decision(false, cooldownSeconds, MSG_DAILY_BLOCK);
        }
        return Decision.ALLOW;
    }

    public Decision checkSearch(String ip) {
        if (!props.isEnabled()) {
            return Decision.ALLOW;
        }
        double mult = multiplierFor(ip);
        ConsumptionProbe probe = searchBuckets.get(ip, k -> buildSearch(mult))
                .tryConsumeAndReturnRemaining(1);
        return probe.isConsumed()
                ? Decision.ALLOW
                : new Decision(false, secondsFromNanos(probe.getNanosToWaitForRefill()), MSG_SEARCH_BUSY);
    }

    /**
     * Real client IP. {@code X-Real-IP}/{@code X-Forwarded-For} are trusted ONLY when the TCP peer
     * ({@code remoteAddr}) is a configured trusted proxy (nginx on the Docker network); otherwise the
     * peer address is used, so a client reaching the backend directly cannot spoof its IP. When trusted,
     * {@code X-Real-IP} wins; else the leftmost {@code X-Forwarded-For} hop (the original client).
     */
    public String resolveClientIp(String remoteAddr, String xRealIp, String xForwardedFor) {
        if (isTrustedProxy(remoteAddr)) {
            if (xRealIp != null && !xRealIp.isBlank()) {
                return xRealIp.trim();
            }
            if (xForwardedFor != null && !xForwardedFor.isBlank()) {
                return xForwardedFor.split(",")[0].trim();
            }
        }
        return remoteAddr;
    }

    // ── Bucket construction ──────────────────────────────────────────────────────────────────────
    // capacity = max instantaneous burst; greedy refill = smooth recovery at the sustained rate.

    private Bucket buildChatShortTerm(double mult) {
        RateLimitProperties.Chat c = props.getChat();
        Bandwidth perMinute = Bandwidth.builder()
                .capacity(scale(c.getBurst(), mult))
                .refillGreedy(scale(c.getPerMinute(), mult), Duration.ofMinutes(1))
                .build();
        Bandwidth perHour = Bandwidth.builder()
                .capacity(scale(c.getPerHour(), mult))
                .refillGreedy(scale(c.getPerHour(), mult), Duration.ofHours(1))
                .build();
        return Bucket.builder().addLimit(perMinute).addLimit(perHour).build();
    }

    private Bucket buildChatDaily(double mult) {
        long perDay = scale(props.getChat().getPerDay(), mult);
        // Greedy: after the cooldown the IP regains a trickle of tokens rather than a thundering reset.
        Bandwidth daily = Bandwidth.builder()
                .capacity(perDay)
                .refillGreedy(perDay, Duration.ofDays(1))
                .build();
        return Bucket.builder().addLimit(daily).build();
    }

    private Bucket buildSearch(double mult) {
        long perMinute = scale(props.getSearch().getPerMinute(), mult);
        Bandwidth band = Bandwidth.builder()
                .capacity(perMinute)
                .refillGreedy(perMinute, Duration.ofMinutes(1))
                .build();
        return Bucket.builder().addLimit(band).build();
    }

    // ── Helpers ──────────────────────────────────────────────────────────────────────────────────

    private boolean isTrustedProxy(String remoteAddr) {
        return matchesAny(trustedProxyRanges, remoteAddr);
    }

    private double multiplierFor(String ip) {
        return matchesAny(sharedRanges, ip) ? props.getSharedMultiplier() : 1.0;
    }

    private static boolean matchesAny(List<CidrMatcher> ranges, String ip) {
        if (ranges.isEmpty() || ip == null || ip.isBlank()) {
            return false;
        }
        try {
            InetAddress addr = InetAddress.ofLiteral(ip);
            for (CidrMatcher range : ranges) {
                if (range.matches(addr)) {
                    return true;
                }
            }
        } catch (RuntimeException ignored) {
            // Not a literal IP — treat as non-matching.
        }
        return false;
    }

    private static long scale(int base, double multiplier) {
        return Math.max(1, Math.round(base * multiplier));
    }

    private static long secondsFromNanos(long nanos) {
        return Math.max(1, (nanos + 999_999_999L) / 1_000_000_000L); // round up, floor of 1s
    }

    private static long secondsUntil(long untilMillis, long nowMillis) {
        return Math.max(1, (untilMillis - nowMillis + 999L) / 1000L);
    }
}

package com.angeasla.ai_labor_rights_guide.ratelimit;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

/**
 * Per-IP rate-limit configuration, bound from {@code app.ratelimit.*}.
 *
 * <p>Chat is throttled in three tiers (short burst + hourly + daily); exceeding the daily quota
 * triggers a temporary cooldown plus an alert — never a permanent ban. Search has a single
 * per-minute ceiling. Shared egress IPs (corporate NAT, VPN exit nodes) host many real users behind
 * one address, so they receive {@code sharedMultiplier}× the limits.
 */
@Getter
@Setter
@ConfigurationProperties(prefix = "app.ratelimit")
public class RateLimitProperties {

    /** Master switch — set false to disable all per-IP throttling (e.g. for load tests). */
    private boolean enabled = true;

    private final Chat chat = new Chat();
    private final Search search = new Search();

    /** CIDRs of shared egress IPs (corporate NAT / VPN exit nodes), IPv4 or IPv6. */
    private List<String> sharedCidrs = new ArrayList<>();

    /** Multiplier applied to every limit for IPs inside {@link #sharedCidrs}. */
    private double sharedMultiplier = 20.0;

    /**
     * CIDRs of trusted reverse proxies. Only when the TCP peer ({@code getRemoteAddr()}) is in one of
     * these do we believe the {@code X-Real-IP}/{@code X-Forwarded-For} headers; otherwise the peer
     * address is used, so a client hitting the backend directly cannot spoof its IP. Defaults to the
     * private ranges (the Docker network nginx sits on).
     */
    private List<String> trustedProxies = new ArrayList<>(List.of(
            "10.0.0.0/8", "172.16.0.0/12", "192.168.0.0/16", "127.0.0.1/32", "::1/128"));

    @Getter
    @Setter
    public static class Chat {
        /** Sustained requests per minute. */
        private int perMinute = 15;
        /** Max instantaneous burst (token-bucket capacity of the per-minute band). */
        private int burst = 5;
        /** Sustained requests per hour. */
        private int perHour = 60;
        /** Hard daily quota; exceeding it triggers the cooldown below + an alert. */
        private int perDay = 300;
        /** Cooldown applied once the daily quota is hit. Temporary — NOT a permanent ban. */
        private Duration blockDuration = Duration.ofHours(1);
    }

    @Getter
    @Setter
    public static class Search {
        /** Sustained searches per minute per IP. */
        private int perMinute = 50;
    }
}

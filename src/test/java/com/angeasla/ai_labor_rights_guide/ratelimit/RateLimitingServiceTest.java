package com.angeasla.ai_labor_rights_guide.ratelimit;

import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Pure-POJO tests for the per-IP rate limiter (no Spring context, so they run even when the
 * transformers embedder can't initialise behind the corporate proxy).
 */
class RateLimitingServiceTest {

    /** AlertService that counts invocations so we can assert "one alert per cooldown trigger". */
    private static final class CountingAlertService extends AlertService {
        final AtomicInteger count = new AtomicInteger();
        @Override
        public void chatDailyCapExceeded(String ip, long dailyCap, long cooldownSeconds) {
            count.incrementAndGet();
        }
    }

    private static RateLimitProperties props() {
        return new RateLimitProperties(); // defaults: chat 15/min burst 5, 60/hr, 300/day, 1h block; search 50/min
    }

    @Test
    void chat_allowsBurstThenThrottlesWithinTheMinute() {
        RateLimitingService svc = new RateLimitingService(props(), new CountingAlertService());
        String ip = "203.0.113.1";

        for (int i = 1; i <= 5; i++) {
            assertTrue(svc.checkChat(ip).allowed(), "burst request " + i + " should pass");
        }
        RateLimitingService.Decision sixth = svc.checkChat(ip);
        assertFalse(sixth.allowed(), "6th immediate request exceeds the burst of 5");
        assertTrue(sixth.retryAfterSeconds() >= 1);
        assertTrue(sixth.message().contains("Περιμένετε"), "transient slow-down message");
    }

    @Test
    void chat_dailyCapTriggersOneAlertAndACooldown() {
        RateLimitProperties p = props();
        p.getChat().setPerDay(3);
        p.getChat().setBurst(100);     // take the short-term bands out of the way
        p.getChat().setPerMinute(100);
        p.getChat().setPerHour(100);
        p.getChat().setBlockDuration(Duration.ofHours(1));
        CountingAlertService alerts = new CountingAlertService();
        RateLimitingService svc = new RateLimitingService(p, alerts);
        String ip = "203.0.113.2";

        for (int i = 1; i <= 3; i++) {
            assertTrue(svc.checkChat(ip).allowed(), "daily request " + i + " within quota");
        }
        RateLimitingService.Decision blocked = svc.checkChat(ip);
        assertFalse(blocked.allowed(), "4th exceeds the daily quota of 3");
        assertTrue(blocked.message().contains("ημερήσιο"), "daily-cooldown message");
        assertTrue(blocked.retryAfterSeconds() > 3000, "cooldown ~1h, got " + blocked.retryAfterSeconds());

        // Still in the penalty box on the next attempt — and NO second alert is fired.
        assertFalse(svc.checkChat(ip).allowed());
        assertEquals(1, alerts.count.get(), "exactly one alert per cooldown trigger");
    }

    @Test
    void sharedCidr_getsMultipliedLimits() {
        RateLimitProperties p = props();
        p.getChat().setBurst(2);
        p.getChat().setPerMinute(2);
        p.getChat().setPerHour(1000);
        p.getChat().setPerDay(1000);
        p.setSharedCidrs(List.of("10.0.0.0/8"));
        p.setSharedMultiplier(5.0);
        RateLimitingService svc = new RateLimitingService(p, new CountingAlertService());

        // Normal IP: burst 2.
        String normal = "203.0.113.3";
        assertTrue(svc.checkChat(normal).allowed());
        assertTrue(svc.checkChat(normal).allowed());
        assertFalse(svc.checkChat(normal).allowed(), "3rd exceeds the un-multiplied burst of 2");

        // Shared/VPN IP inside 10.0.0.0/8: burst 2 * 5 = 10.
        String shared = "10.1.2.3";
        for (int i = 1; i <= 10; i++) {
            assertTrue(svc.checkChat(shared).allowed(), "shared burst request " + i + " (limit 10)");
        }
        assertFalse(svc.checkChat(shared).allowed(), "11th exceeds the multiplied burst of 10");
    }

    @Test
    void search_hasItsOwnPerMinuteCeiling() {
        RateLimitProperties p = props();
        p.getSearch().setPerMinute(3);
        RateLimitingService svc = new RateLimitingService(p, new CountingAlertService());
        String ip = "203.0.113.4";

        for (int i = 1; i <= 3; i++) {
            assertTrue(svc.checkSearch(ip).allowed(), "search " + i + " within 3/min");
        }
        RateLimitingService.Decision fourth = svc.checkSearch(ip);
        assertFalse(fourth.allowed());
        assertTrue(fourth.message().contains("αναζητήσεις"), "search-specific message");
    }

    @Test
    void search_andChatBucketsAreIndependent() {
        RateLimitProperties p = props();
        p.getSearch().setPerMinute(1);
        RateLimitingService svc = new RateLimitingService(p, new CountingAlertService());
        String ip = "203.0.113.5";

        assertTrue(svc.checkSearch(ip).allowed());
        assertFalse(svc.checkSearch(ip).allowed(), "search exhausted");
        // Chat must still work for the same IP — separate bucket.
        assertTrue(svc.checkChat(ip).allowed(), "chat unaffected by search exhaustion");
    }

    @Test
    void disabled_allowsEverything() {
        RateLimitProperties p = props();
        p.setEnabled(false);
        p.getChat().setPerDay(1);
        RateLimitingService svc = new RateLimitingService(p, new CountingAlertService());
        String ip = "203.0.113.6";

        for (int i = 0; i < 50; i++) {
            assertTrue(svc.checkChat(ip).allowed(), "disabled limiter never blocks");
        }
    }
}

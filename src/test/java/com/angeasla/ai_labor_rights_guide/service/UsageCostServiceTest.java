package com.angeasla.ai_labor_rights_guide.service;

import com.angeasla.ai_labor_rights_guide.ratelimit.AlertService;
import org.junit.jupiter.api.Test;

import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Pure-POJO tests for token cost accounting and the one-shot daily-spend alert (no Spring context;
 * rates/threshold are passed straight to the constructor, like {@code RateLimitingServiceTest}).
 */
class UsageCostServiceTest {

    private static final double EPS = 1e-9;

    /** AlertService that counts cost-alert invocations and remembers the last args. */
    private static final class CountingAlertService extends AlertService {
        final AtomicInteger count = new AtomicInteger();
        volatile double lastSpent;
        volatile double lastThreshold;
        @Override
        public void dailyCostThresholdExceeded(double spent, double threshold) {
            count.incrementAndGet();
            lastSpent = spent;
            lastThreshold = threshold;
        }
    }

    // input 0.27 / 1M, output 1.10 / 1M — the configured defaults.
    private static UsageCostService svc(double threshold, CountingAlertService alerts) {
        return new UsageCostService(0.27, 1.10, threshold, alerts);
    }

    @Test
    void costMath_forKnownTokenCounts() {
        UsageCostService svc = svc(1000.0, new CountingAlertService());

        // 1M prompt + 1M completion = 0.27 + 1.10 = 1.37
        assertEquals(1.37, svc.record(1_000_000, 1_000_000), EPS);

        // 500k prompt + 250k completion = 0.135 + 0.275 = 0.41
        UsageCostService svc2 = svc(1000.0, new CountingAlertService());
        assertEquals(0.41, svc2.record(500_000, 250_000), EPS);
    }

    @Test
    void dailyTotal_accumulatesAcrossRequests() {
        UsageCostService svc = svc(1000.0, new CountingAlertService());

        svc.record(1_000_000, 0);   // 0.27
        svc.record(0, 1_000_000);   // 1.10
        assertEquals(1.37, svc.currentDailyTotal(), EPS);
    }

    @Test
    void alert_firesExactlyOnceWhenCrossingThreshold_andNotAgainSameDay() {
        CountingAlertService alerts = new CountingAlertService();
        UsageCostService svc = svc(1.0, alerts); // threshold $1.00

        svc.record(1_000_000, 0); // total 0.27 — under threshold, no alert
        assertEquals(0, alerts.count.get());

        svc.record(0, 1_000_000); // total 1.37 — crosses 1.0 -> exactly one alert
        assertEquals(1, alerts.count.get());
        assertEquals(1.37, alerts.lastSpent, EPS);
        assertEquals(1.0, alerts.lastThreshold, EPS);

        // Keep spending the same day: total keeps growing but NO second alert.
        svc.record(1_000_000, 1_000_000); // total 2.74
        svc.record(1_000_000, 1_000_000); // total 4.11
        assertEquals(1, alerts.count.get(), "exactly one cost alert per day");
        assertEquals(4.11, svc.currentDailyTotal(), EPS);
    }

    @Test
    void alert_firesOnFirstRequestWhenItAloneCrossesThreshold() {
        CountingAlertService alerts = new CountingAlertService();
        UsageCostService svc = svc(1.0, alerts);

        svc.record(1_000_000, 1_000_000); // 1.37 >= 1.0 on the very first request
        assertEquals(1, alerts.count.get());
    }

    @Test
    void zeroAndNegativeTokenCounts_areTreatedAsZeroCost() {
        CountingAlertService alerts = new CountingAlertService();
        UsageCostService svc = svc(1.0, alerts);

        assertEquals(0.0, svc.record(0, 0), EPS);
        // Negative counts (defensive: should never happen) clamp to zero rather than subtracting.
        assertEquals(0.0, svc.record(-5, -10), EPS);
        assertEquals(0.0, svc.currentDailyTotal(), EPS);
        assertEquals(0, alerts.count.get());
    }

    @Test
    void zeroThreshold_alertsOnFirstNonTrivialSpend() {
        CountingAlertService alerts = new CountingAlertService();
        UsageCostService svc = svc(0.0, alerts);

        // total 0.27 >= 0.0 -> fires once.
        svc.record(1_000_000, 0);
        assertEquals(1, alerts.count.get());
        svc.record(1_000_000, 0);
        assertEquals(1, alerts.count.get(), "still one alert for the day");
    }
}

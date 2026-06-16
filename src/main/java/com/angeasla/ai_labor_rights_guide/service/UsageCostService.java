package com.angeasla.ai_labor_rights_guide.service;

import com.angeasla.ai_labor_rights_guide.ratelimit.AlertService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Locale;

/**
 * Per-request token accounting and a soft daily-spend guard rail. For every successful chat call we
 * log one structured {@code CHAT_COST} line (token in/out, this-request cost, running daily total) so
 * log-based dashboards can chart spend without parsing prose.
 *
 * <p>A single in-memory daily total is kept and reset when the calendar day rolls over (single-node
 * deployment behind one nginx — no distributed counter needed). When the running total first crosses
 * {@code app.cost.daily-alert-threshold} we fire {@link AlertService#dailyCostThresholdExceeded} exactly
 * <em>once</em> for that day, mirroring the rate limiter's one-shot daily alert; subsequent requests the
 * same day keep accumulating but stay quiet until the date changes and the counter resets.
 *
 * <p>Chat requests run on virtual threads, so the accumulate-check-alert sequence is done under a single
 * lock to keep the total consistent and the alert genuinely one-shot.
 */
@Service
public class UsageCostService {

    private static final Logger log = LoggerFactory.getLogger(UsageCostService.class);

    private static final double TOKENS_PER_MILLION = 1_000_000.0;

    private final double inputCostPer1m;
    private final double outputCostPer1m;
    private final double dailyAlertThreshold;
    private final AlertService alerts;

    // Guarded by `this`. Day is tracked so the total (and the one-shot alert flag) reset at midnight.
    private LocalDate currentDay = LocalDate.now();
    private double dailyTotalCost = 0.0;
    private boolean alertedToday = false;

    public UsageCostService(@Value("${app.cost.input-per-1m-tokens:0.27}") double inputCostPer1m,
                            @Value("${app.cost.output-per-1m-tokens:1.10}") double outputCostPer1m,
                            @Value("${app.cost.daily-alert-threshold:10.0}") double dailyAlertThreshold,
                            AlertService alerts) {
        this.inputCostPer1m = inputCostPer1m;
        this.outputCostPer1m = outputCostPer1m;
        this.dailyAlertThreshold = dailyAlertThreshold;
        this.alerts = alerts;
    }

    /**
     * Records one request's token usage: computes its estimated cost, logs the {@code CHAT_COST} line,
     * adds it to today's running total and — if the total has just crossed the alert threshold — fires
     * the daily-cost alert once. Negative/zero token counts are treated as zero. Returns the estimated
     * cost of this request (handy for tests/callers).
     */
    public double record(int promptTokens, int completionTokens) {
        int in = Math.max(0, promptTokens);
        int out = Math.max(0, completionTokens);
        double cost = (in / TOKENS_PER_MILLION) * inputCostPer1m
                + (out / TOKENS_PER_MILLION) * outputCostPer1m;

        double runningTotal;
        boolean crossedThreshold;
        synchronized (this) {
            rolloverIfNewDayLocked();
            dailyTotalCost += cost;
            runningTotal = dailyTotalCost;
            // One-shot: fire only on the transition across the threshold, then suppress for the rest of the day.
            crossedThreshold = !alertedToday && runningTotal >= dailyAlertThreshold;
            if (crossedThreshold) {
                alertedToday = true;
            }
        }

        log.info("CHAT_COST tokensIn={} tokensOut={} estCost={} dailyTotal={}", in, out, money(cost), money(runningTotal));
        if (crossedThreshold) {
            alerts.dailyCostThresholdExceeded(runningTotal, dailyAlertThreshold);
        }
        return cost;
    }

    /** Current accumulated estimated spend for today (rolls over with the calendar day). */
    public synchronized double currentDailyTotal() {
        rolloverIfNewDayLocked();
        return dailyTotalCost;
    }

    /** Format a money amount to 4 decimals with a '.' separator regardless of JVM locale — for log lines. */
    private static String money(double value) {
        return String.format(Locale.ROOT, "%.4f", value);
    }

    private void rolloverIfNewDayLocked() {
        LocalDate today = LocalDate.now();
        if (!today.equals(currentDay)) {
            currentDay = today;
            dailyTotalCost = 0.0;
            alertedToday = false;
        }
    }
}

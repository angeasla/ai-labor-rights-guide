package com.angeasla.ai_labor_rights_guide.ratelimit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * Alert seam for abuse signals. Currently emits a stable, structured WARN line that log-based
 * alerting (Loki / ELK / CloudWatch metric filter) can trigger on. Swap the body for email/Slack/etc.
 * without touching the rate-limit logic.
 */
@Service
public class AlertService {

    private static final Logger log = LoggerFactory.getLogger(AlertService.class);

    /** Fired when an IP exhausts its daily chat quota and enters the cooldown. */
    public void chatDailyCapExceeded(String ip, long dailyCap, long cooldownSeconds) {
        log.warn("RATE_LIMIT_ALERT chat daily quota exhausted ip={} cap={} cooldownSeconds={} action=temporary-cooldown",
                ip, dailyCap, cooldownSeconds);
    }

    /** Fired once per day when the estimated cumulative LLM spend crosses the configured threshold. */
    public void dailyCostThresholdExceeded(double spent, double threshold) {
        log.warn("COST_ALERT daily estimated spend exceeded spent={} threshold={}", spent, threshold);
    }
}

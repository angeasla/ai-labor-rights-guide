package com.angeasla.ai_labor_rights_guide.calc;

import static com.angeasla.ai_labor_rights_guide.calc.CalcConstants.*;

/**
 * Unemployment benefit (επίδομα ανεργίας, ΔΥΠΑ).
 * Ν.1545/1985 + ΥΑ 35186/929/1999. Verified against CALCULATOR_SPECS.md.
 */
public final class UnemploymentCalculator {

    private UnemploymentCalculator() {
    }

    public record UnemploymentResult(double monthlyBenefit, double dailyBenefit, int durationMonths,
                                     double totalPayout, int tierPercent, int dependents, boolean eligible) {
    }

    /**
     * Months of benefit by insured days on the 14-month reference basis (current ΔΥΠΑ ladder, min 5 months).
     * Does not model the age-≥49 exception (210 days → 12 months) — that needs the claimant's age.
     */
    public static int durationMonths(int insuredDays) {
        if (insuredDays < 125) return 0;
        if (insuredDays < 150) return 5;   // 125–149
        if (insuredDays < 180) return 6;   // 150–179
        if (insuredDays < 220) return 8;   // 180–219
        if (insuredDays < 250) return 10;  // 220–249
        return 12;                         // 250+
    }

    /** Convenience overload — no dependents. */
    public static UnemploymentResult unemployment(double avgMonthlySalary, int insuredDays) {
        return unemployment(avgMonthlySalary, insuredDays, 0);
    }

    /**
     * Regular ΔΥΠΑ benefit. The daily amount is pegged to the minimum wage and tiered by the claimant's
     * average gross monthly earnings (last 6 months); +10% per dependent family member.
     */
    public static UnemploymentResult unemployment(double avgMonthlySalary, int insuredDays, int dependents) {
        if (avgMonthlySalary <= 0) {
            throw new IllegalArgumentException("avgMonthlySalary must be > 0");
        }
        int deps = Math.max(0, dependents);
        if (insuredDays < UNEMP_MIN_INSURED_DAYS) {
            return new UnemploymentResult(0.0, 0.0, 0, 0.0, 0, deps, false);
        }
        double dailyBenefit;
        int tierPercent;
        if (avgMonthlySalary >= UNEMP_TIER1_MIN_AVG) {
            dailyBenefit = UNEMP_DAILY_FULL;
            tierPercent = 100;
        } else if (avgMonthlySalary >= UNEMP_TIER2_MIN_AVG) {
            dailyBenefit = UNEMP_DAILY_75;
            tierPercent = 75;
        } else {
            dailyBenefit = UNEMP_DAILY_50;
            tierPercent = 50;
        }
        double monthlyBenefit = dailyBenefit * UNEMP_DAYS_PER_MONTH * (1 + UNEMP_DEPENDENT_UPLIFT * deps);
        int duration = durationMonths(insuredDays);
        double totalPayout = monthlyBenefit * duration;
        return new UnemploymentResult(round2(monthlyBenefit), round2(dailyBenefit), duration,
                round2(totalPayout), tierPercent, deps, true);
    }
}

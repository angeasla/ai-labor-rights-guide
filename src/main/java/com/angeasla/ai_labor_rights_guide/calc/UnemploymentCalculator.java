package com.angeasla.ai_labor_rights_guide.calc;

import static com.angeasla.ai_labor_rights_guide.calc.CalcConstants.*;

/**
 * Unemployment benefit (επίδομα ανεργίας, ΔΥΠΑ).
 * Ν.1545/1985 + ΥΑ 35186/929/1999. Verified against CALCULATOR_SPECS.md.
 */
public final class UnemploymentCalculator {

    private UnemploymentCalculator() {
    }

    public record UnemploymentResult(double monthlyBenefit, int durationMonths, double avgDailyWage,
                                     double dailyBenefit, double uncappedMonthly, double totalPayout,
                                     boolean eligible, String boundApplied) {
    }

    /** Months of benefit by insured days in the last 14 months (Ν.1545/1985 ladder). */
    public static int durationMonths(int insuredDays) {
        if (insuredDays < 125) return 0;
        if (insuredDays < 150) return 2;
        if (insuredDays < 180) return 3;
        if (insuredDays < 220) return 4;
        if (insuredDays < 260) return 5;
        if (insuredDays < 300) return 6;
        if (insuredDays < 425) return 8;
        if (insuredDays < 600) return 10;
        return 12;
    }

    public static UnemploymentResult unemployment(double avgMonthlySalary, int insuredDays) {
        if (avgMonthlySalary <= 0) {
            throw new IllegalArgumentException("avgMonthlySalary must be > 0");
        }
        if (insuredDays < UNEMP_MIN_INSURED_DAYS) {
            return new UnemploymentResult(0.0, 0, 0.0, 0.0, 0.0, 0.0, false, "");
        }
        double avgDailyWage = avgMonthlySalary * 12 / UNEMP_ANNUAL_TO_DAILY;
        double dailyBenefit = avgDailyWage * UNEMP_REPLACEMENT_RATE;
        double uncappedMonthly = dailyBenefit * UNEMP_DAYS_PER_MONTH;
        double monthlyBenefit = Math.min(UNEMP_BENEFIT_CAP, Math.max(UNEMP_BENEFIT_FLOOR, uncappedMonthly));
        int duration = durationMonths(insuredDays);
        double totalPayout = monthlyBenefit * duration;
        String boundApplied;
        if (uncappedMonthly < UNEMP_BENEFIT_FLOOR) {
            boundApplied = "FLOOR";
        } else if (uncappedMonthly > UNEMP_BENEFIT_CAP) {
            boundApplied = "CAP";
        } else {
            boundApplied = "SALARY";
        }
        return new UnemploymentResult(round2(monthlyBenefit), duration, round2(avgDailyWage), round2(dailyBenefit),
                round2(uncappedMonthly), round2(totalPayout), true, boundApplied);
    }
}

package com.angeasla.ai_labor_rights_guide.calc;

import static com.angeasla.ai_labor_rights_guide.calc.CalcConstants.*;

/**
 * Dismissal severance (αποζημίωση απόλυσης).
 * Ν.2112/1920 + Ν.3198/1955 + Ν.3899/2010 (notice) + Ν.4093/2012 (unified ladder to 12 months).
 * Verified against CALCULATOR_SPECS.md.
 */
public final class SeveranceCalculator {

    private SeveranceCalculator() {
    }

    public record SeveranceResult(double amount, int compensationMonths, double calcSalary,
                                  int noticePeriodMonths, boolean withNotice) {
    }

    public static SeveranceResult severance(double grossMonthly, int completedYears, boolean withNotice) {
        if (grossMonthly <= 0) {
            throw new IllegalArgumentException("grossMonthly must be > 0");
        }
        int years = Math.max(0, completedYears);
        double calcSalary = grossMonthly * SEVERANCE_HOLIDAY_UPLIFT;
        int months = monthsWithoutNotice(years);
        double full = months * calcSalary;
        double amount = withNotice ? full * SEVERANCE_WITH_NOTICE_FACTOR : full;
        return new SeveranceResult(round2(amount), months, round2(calcSalary), noticePeriodMonths(years), withNotice);
    }

    /** Months of pay (without notice) by completed years of service. Caps at 12 (Ν.4093/2012). */
    public static int monthsWithoutNotice(int years) {
        if (years < 1) return 0;
        if (years < 4) return 2;
        if (years < 6) return 3;
        if (years < 8) return 4;
        if (years < 10) return 5;
        if (years < 11) return 6;
        if (years < 12) return 7;
        if (years < 13) return 8;
        if (years < 14) return 9;
        if (years < 15) return 10;
        if (years < 16) return 11;
        return 12;
    }

    /** Required notice period in months (Ν.3899/2010). Caps at 4. */
    public static int noticePeriodMonths(int years) {
        if (years < 1) return 0;
        if (years < 2) return 1;
        if (years < 5) return 2;
        if (years < 10) return 3;
        return 4;
    }
}

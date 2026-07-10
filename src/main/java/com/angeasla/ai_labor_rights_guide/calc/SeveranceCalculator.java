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

    // ---- Voluntary-retirement severance (Ν.2112/1920, Ν.3863/2010, Ν.4093/2012 αρ.74) ----
    // DISTINCT from dismissal severance above: uses the PLAIN monthly salary (no 14/12 δώρα uplift),
    // two regime ladders (OLD/NEW by hire date), and a 17-year full-factor rule.

    public enum RetirementRegime {OLD, NEW}

    public record RetirementSeveranceResult(double amount, int multiplierMonths, double monthlySalary,
                                            int totalMonths, int years, int months, double retirementFactor,
                                            RetirementRegime regime) {
    }

    /** NEW-regime multiplier (months of pay) by total months of service. */
    public static int retirementMultiplierNew(int totalMonths) {
        if (totalMonths < 12) return 0;
        if (totalMonths < 24) return 1;
        if (totalMonths < 60) return 2;
        if (totalMonths < 120) return 3;
        if (totalMonths < 180) return 4;
        if (totalMonths < 240) return 5;
        return 6;
    }

    /** OLD-regime multiplier (months of pay) by total months of service. */
    public static int retirementMultiplierOld(int totalMonths) {
        if (totalMonths < 12) return 0;
        if (totalMonths < 48) return 2;
        if (totalMonths < 72) return 3;
        if (totalMonths < 96) return 4;
        if (totalMonths < 120) return 5;
        if (totalMonths < 144) return 6;
        if (totalMonths < 168) return 7;
        if (totalMonths < 192) return 8;
        if (totalMonths < 216) return 9;
        if (totalMonths < 240) return 10;
        return 12;
    }

    /**
     * Voluntary-retirement severance, pure deterministic core. Uses the plain monthly salary (NO δώρα
     * uplift). Full (×1.0) factor at ≥17 years of service, otherwise half (×0.5).
     */
    public static RetirementSeveranceResult retirementSeverance(double monthlySalary, int totalMonths,
                                                                RetirementRegime regime) {
        if (monthlySalary <= 0) {
            throw new IllegalArgumentException("monthlySalary must be > 0");
        }
        totalMonths = Math.max(0, totalMonths);
        int multiplier = regime == RetirementRegime.OLD
                ? retirementMultiplierOld(totalMonths)
                : retirementMultiplierNew(totalMonths);
        double standard = monthlySalary * multiplier;
        double retirementFactor = totalMonths / 12.0 >= RETIREMENT_FULL_FACTOR_YEARS ? 1.0 : 0.5;
        double amount = standard * retirementFactor;
        int years = totalMonths / 12;
        int months = totalMonths % 12;
        return new RetirementSeveranceResult(round2(amount), multiplier, round2(monthlySalary),
                totalMonths, years, months, retirementFactor, regime);
    }

    /**
     * Convenience overload: derives total months of service from {@code hireDate} to today and
     * auto-selects the regime by hire date (override with a non-null {@code regimeOverride}).
     */
    public static RetirementSeveranceResult retirementSeverance(double monthlySalary, java.time.LocalDate hireDate,
                                                                RetirementRegime regimeOverride) {
        java.time.Period p = java.time.Period.between(hireDate, java.time.LocalDate.now());
        int totalMonths = p.getYears() * 12 + p.getMonths();
        RetirementRegime regime = regimeOverride != null
                ? regimeOverride
                : (hireDate.isAfter(RETIREMENT_REGIME_CUTOFF) ? RetirementRegime.NEW : RetirementRegime.OLD);
        return retirementSeverance(monthlySalary, totalMonths, regime);
    }
}

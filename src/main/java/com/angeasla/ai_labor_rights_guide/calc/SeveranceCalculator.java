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

    // ---- Voluntary-retirement severance (Ν.3198/1955 art.8 §2) ----
    // A worker who leaves (υπάλληλος: leaves or is let go) having met the conditions for a FULL old-age
    // pension gets a REDUCED share of the FULL no-notice dismissal severance: 40% if covered by
    // supplementary (επικουρική) insurance and eligible for the supplementary pension, otherwise 50%.
    // Same completed-years ladder and 14/12 δώρα uplift as dismissal severance. There is NO hire-date
    // "OLD/NEW regime" and NO 17-year full/half rule (both were unsupported). Applies to υπάλληλοι and
    // εργατοτεχνίτες alike since 1.1.2022 (Ν.4808/2021 art.64).

    public record RetirementSeveranceResult(double amount, double factor, double dismissalSeveranceBase,
                                            int compensationMonths, double calcSalary, int years,
                                            boolean supplementaryInsured) {
    }

    /**
     * Voluntary-retirement severance = a percentage of the full no-notice dismissal severance.
     * {@code supplementaryInsured} true ⇒ 40% (covered by επικουρική &amp; eligible for it), false ⇒ 50%.
     */
    public static RetirementSeveranceResult retirementSeverance(double monthlySalary, int completedYears,
                                                                boolean supplementaryInsured) {
        if (monthlySalary <= 0) {
            throw new IllegalArgumentException("monthlySalary must be > 0");
        }
        int years = Math.max(0, completedYears);
        double calcSalary = monthlySalary * SEVERANCE_HOLIDAY_UPLIFT;   // ×14/12 for δώρα + επίδομα αδείας
        int months = monthsWithoutNotice(years);                       // full Ν.2112/1920 no-notice ladder
        double dismissalBase = months * calcSalary;
        double factor = supplementaryInsured
                ? RETIREMENT_FACTOR_SUPPLEMENTARY
                : RETIREMENT_FACTOR_NO_SUPPLEMENTARY;
        double amount = dismissalBase * factor;
        return new RetirementSeveranceResult(round2(amount), factor, round2(dismissalBase),
                months, round2(calcSalary), years, supplementaryInsured);
    }
}

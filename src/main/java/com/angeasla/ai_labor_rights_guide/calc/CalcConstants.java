package com.angeasla.ai_labor_rights_guide.calc;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Central, year-versioned constants and shared helpers for all labor-law calculators.
 * Update these once per year. The verified spec + sources are in CALCULATOR_SPECS.md.
 */
public final class CalcConstants {

    private CalcConstants() {
    }

    // --- EFKA contributions (2026) ---
    public static final double EFKA_EMPLOYEE_RATE = 0.1337;
    public static final double EFKA_EMPLOYER_RATE = 0.2229; // informational; ±~0.5% sector variance
    public static final double EFKA_MONTHLY_CEILING = 7761.94;

    // --- Income tax (2026, Ν.5246/2025) ---
    // Marginal rates over annual-income upper limits. The 0–10k / 10–20k / 20–30k band rates depend on
    // the number of dependent children AND the taxpayer's age (youth relief) — see taxBracketRates().
    public static final double[] TAX_BRACKET_LIMITS = {10_000, 20_000, 30_000, 40_000, 60_000, Double.POSITIVE_INFINITY};
    public static final int YOUTH_AGE_MAX = 25;        // age ≤25: first two bands 0%
    public static final int YOUNG_ADULT_AGE_MAX = 30;  // age 26–30: first two bands 9%

    // Family tax-credit base by number of children (index 0..5); beyond 5 -> 1780 + 220 per extra child.
    public static final double[] TAX_CREDIT_BASE = {777, 900, 1120, 1340, 1580, 1780};
    public static final double TAX_CREDIT_EXTRA_PER_CHILD_OVER_5 = 220;
    public static final double TAX_CREDIT_REDUCTION_THRESHOLD = 12_000;
    public static final double TAX_CREDIT_REDUCTION_PER_1000 = 20.0; // €20 per €1000 of taxable income over threshold
    public static final double DISABILITY_TAX_CREDIT = 200.0; // uncertain for 2026; optional, default off

    // --- Daily wage / hourly derivation ---
    public static final int DAYS_PER_MONTH_5DAY = 25;
    public static final int DAYS_PER_MONTH_6DAY = 26;
    public static final int HOURS_PER_DAY = 8;
    // Legal hourly wage (ωρομίσθιο) = monthly salary × 0.006 (= ημερομίσθιο × 6/40). The ΣΕΠΕ/KEPEA
    // standard for the overtime/night base; confirmed by the KEPEA cross-check (€1000 → €6.00).
    public static final double LEGAL_HOURLY_FACTOR = 0.006;

    // --- Holiday bonuses (δώρα) ---
    public static final double LEAVE_INCREMENT = 1.0 / 24.0; // επίδομα αδείας, mandatory; exact 1/24 (not 0.04166)

    // --- Severance ---
    public static final double SEVERANCE_HOLIDAY_UPLIFT = 14.0 / 12.0; // 1/6 προσαύξηση for δώρα + επίδομα αδείας
    public static final double SEVERANCE_WITH_NOTICE_FACTOR = 0.5;

    // --- Pensions ---
    public static final double NATIONAL_PENSION_BASE_2026 = 446.86;
    public static final int PENSION_MIN_INSURANCE_YEARS = 15;
    public static final int PENSION_FULL_INSURANCE_YEARS = 20;
    public static final int PENSION_FULL_RESIDENCE_YEARS = 40;
    public static final int PENSION_FULL_AGE = 67;
    // Contributory accrual: per-year rate (%) within each band upper-bound (Ν.4670/2020, Πίνακας 2).
    public static final int[] CONTRIB_BAND_LIMITS = {15, 18, 21, 24, 27, 30, 33, 36, 40};
    public static final double[] CONTRIB_BAND_RATES = {0.77, 0.84, 0.90, 0.96, 1.03, 1.21, 1.98, 2.50, 2.55};
    public static final double CONTRIB_OVER_40_RATE = 0.50;

    /** Round a monetary value to 2 decimals, HALF_UP. */
    public static double round2(double v) {
        return BigDecimal.valueOf(v).setScale(2, RoundingMode.HALF_UP).doubleValue();
    }

    /** Family tax-credit base for a given number of children. */
    public static double creditBase(int children) {
        int c = Math.max(0, children);
        if (c < TAX_CREDIT_BASE.length) {
            return TAX_CREDIT_BASE[c];
        }
        return TAX_CREDIT_BASE[5] + TAX_CREDIT_EXTRA_PER_CHILD_OVER_5 * (c - 5);
    }

    /**
     * 2026 marginal rates per band as a function of dependent children and age (Ν.5246/2025).
     * Bands [0–10k, 10–20k, 20–30k, 30–40k, 40–60k, 60k+]: age ≤25 → first two bands 0%; age 26–30 →
     * first two bands 9%; age ≥31 (or unspecified, {@code age<=0}) → standard, the 10–20k rate reduced
     * per child (20/18/16/9/0 for 0/1/2/3/4+). The 20–30k band is child-dependent for every age
     * (−2 pp per child, floor 14%). Four+ children also zero the first two bands. Top three fixed.
     */
    public static double[] taxBracketRates(int children, int age) {
        int c = Math.max(0, children);
        boolean youth = age >= 1 && age <= YOUTH_AGE_MAX;                       // ≤25
        boolean youngAdult = age > YOUTH_AGE_MAX && age <= YOUNG_ADULT_AGE_MAX; // 26–30

        double b0; // 0–10k
        double b1; // 10–20k
        if (youth) {
            b0 = 0.0;
            b1 = 0.0;
        } else if (youngAdult) {
            b0 = (c >= 4) ? 0.0 : 0.09;
            b1 = (c >= 4) ? 0.0 : 0.09;
        } else { // ≥31 or unspecified
            b0 = (c >= 4) ? 0.0 : 0.09;
            b1 = switch (Math.min(c, 4)) {
                case 0 -> 0.20;
                case 1 -> 0.18;
                case 2 -> 0.16;
                case 3 -> 0.09;
                default -> 0.0; // 4+
            };
        }
        double b2 = Math.max(0.14, 0.26 - 0.02 * c); // 20–30k: −2 pp/child, floor 14%
        return new double[] {b0, b1, b2, 0.34, 0.39, 0.44};
    }

    /** Progressive annual income tax on taxable income, before tax credits (child/age-dependent rates). */
    public static double progressiveTax(double taxableIncome, int children, int age) {
        double[] rates = taxBracketRates(children, age);
        double tax = 0, prev = 0;
        for (int i = 0; i < TAX_BRACKET_LIMITS.length; i++) {
            if (taxableIncome <= prev) {
                break;
            }
            double limit = TAX_BRACKET_LIMITS[i];
            tax += (Math.min(taxableIncome, limit) - prev) * rates[i];
            prev = limit;
        }
        return tax;
    }
}

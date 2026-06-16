package com.angeasla.ai_labor_rights_guide.calc;

import static com.angeasla.ai_labor_rights_guide.calc.CalcConstants.*;

/**
 * Pension estimates: national (εθνική) and contributory (ανταποδοτική).
 * Ν.4387/2016 art.7 (national) + Ν.4670/2020 art.24 (contributory). Verified against CALCULATOR_SPECS.md.
 */
public final class PensionCalculators {

    private PensionCalculators() {
    }

    public record NationalPensionResult(double monthlyAmount, boolean reduced) {
    }

    public record ContributoryPensionResult(double monthlyAmount, double replacementRatePct) {
    }

    public static NationalPensionResult nationalPension(int insuranceYears, int residenceYears, int retirementAge) {
        if (insuranceYears < PENSION_MIN_INSURANCE_YEARS) {
            return new NationalPensionResult(0.0, true);
        }
        double amount = NATIONAL_PENSION_BASE_2026;
        boolean reduced = false;

        if (residenceYears < PENSION_FULL_RESIDENCE_YEARS) {
            amount *= (double) residenceYears / PENSION_FULL_RESIDENCE_YEARS;
            reduced = true;
        }
        if (insuranceYears < PENSION_FULL_INSURANCE_YEARS) {
            amount *= 1 - (PENSION_FULL_INSURANCE_YEARS - insuranceYears) * 0.02;
            reduced = true;
        }
        // Early-retirement reduction on the national component (e-ΕΦΚΑ working convention; approximation).
        if (retirementAge < PENSION_FULL_AGE && insuranceYears < PENSION_FULL_RESIDENCE_YEARS) {
            amount *= 1 - Math.min((PENSION_FULL_AGE - retirementAge) * 0.06, 0.30);
            reduced = true;
        }
        return new NationalPensionResult(round2(amount), reduced);
    }

    public static ContributoryPensionResult contributoryPension(double pensionableEarnings, int insuranceYears) {
        if (pensionableEarnings <= 0) {
            throw new IllegalArgumentException("pensionableEarnings must be > 0");
        }
        if (insuranceYears < PENSION_MIN_INSURANCE_YEARS) {
            return new ContributoryPensionResult(0.0, 0.0);
        }
        double ratePct = cumulativeReplacementRate(insuranceYears);
        double amount = pensionableEarnings * ratePct / 100.0;
        return new ContributoryPensionResult(round2(amount), round2(ratePct));
    }

    /** Cumulative replacement rate (%) over the Ν.4670/2020 banded per-year accrual ladder. */
    public static double cumulativeReplacementRate(int years) {
        double total = 0;
        int prev = 0;
        for (int i = 0; i < CONTRIB_BAND_LIMITS.length; i++) {
            if (years <= prev) {
                break;
            }
            int top = CONTRIB_BAND_LIMITS[i];
            int seg = Math.min(years, top) - prev;
            total += seg * CONTRIB_BAND_RATES[i];
            prev = top;
        }
        if (years > 40) {
            total += (years - 40) * CONTRIB_OVER_40_RATE;
        }
        return total;
    }
}

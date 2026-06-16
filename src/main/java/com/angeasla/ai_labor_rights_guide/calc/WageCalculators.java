package com.angeasla.ai_labor_rights_guide.calc;

import static com.angeasla.ai_labor_rights_guide.calc.CalcConstants.*;

/**
 * Wage calculators: gross↔net salary, overtime, night work.
 * Pure functions (no Spring deps) — verified against Greek law in CALCULATOR_SPECS.md.
 */
public final class WageCalculators {

    private WageCalculators() {
    }

    /** Overtime category surcharges (Ν.4808/2021 + Ν.5053/2023). */
    public enum OvertimeType {
        OVERWORK(0.20),        // υπερεργασία, 41st–45th weekly hour
        LEGAL(0.40),           // νόμιμη υπερωρία, ≤150 h/yr
        LEGAL_OVER_150(0.60),  // νόμιμη υπερωρία, >150 h/yr
        ILLEGAL(1.20);         // παράνομη/αδήλωτη υπερωρία

        public final double rate;

        OvertimeType(double rate) {
            this.rate = rate;
        }
    }

    public record GrossToNetResult(double netMonthly, double efkaEmployee, double incomeTaxMonthly,
                                   double effectiveTaxRatePct, double employerCost, double efkaEmployer) {
    }

    public record OvertimeResult(double hourlyRate, double baseAmount, double surchargeAmount,
                                 double total, double surchargePct) {
    }

    public record NightWorkResult(double hourlyRate, double baseAmount, double allowance,
                                  double total, double surchargePct) {
    }

    /** All per-hour overtime & surcharge rates at once (for the UI rate table), off the ×0.006 base. */
    public record OvertimeRatesResult(double hourlyRate, double overwork, double legalOvertime,
                                      double legalOvertimeOver150, double illegalOvertime,
                                      double nightIncrement, double totalNightRate,
                                      double sixthDayStandard, double sixthDayShift) {
    }

    // ---- Gross → Net ----

    /** Convenience overload — adult (age ≥31) scale. */
    public static GrossToNetResult grossToNet(double monthlyGross, int children, int months, boolean disability) {
        return grossToNet(monthlyGross, children, months, disability, 0);
    }

    public static GrossToNetResult grossToNet(double monthlyGross, int children, int months, boolean disability, int age) {
        if (monthlyGross <= 0) {
            throw new IllegalArgumentException("monthlyGross must be > 0");
        }
        if (months != 12 && months != 14) {
            throw new IllegalArgumentException("months must be 12 or 14");
        }
        int mult = months;
        double monthlyEfka = Math.min(monthlyGross, EFKA_MONTHLY_CEILING) * EFKA_EMPLOYEE_RATE;
        double annualGross = monthlyGross * mult;
        double annualEfka = monthlyEfka * mult;
        double taxable = Math.max(0, annualGross - annualEfka);

        double bracketTax = progressiveTax(taxable, children, age);
        double reduction = (children >= 5)
                ? 0
                : Math.max(0, (taxable - TAX_CREDIT_REDUCTION_THRESHOLD) / 1000.0 * TAX_CREDIT_REDUCTION_PER_1000);
        double credit = Math.max(0, creditBase(children) - reduction) + (disability ? DISABILITY_TAX_CREDIT : 0);
        double annualTax = Math.max(0, bracketTax - credit);
        double monthlyTax = annualTax / mult;

        double net = monthlyGross - monthlyEfka - monthlyTax;
        double efkaEmployer = monthlyGross * EFKA_EMPLOYER_RATE;
        double effRate = (monthlyTax / monthlyGross) * 100;

        return new GrossToNetResult(round2(net), round2(monthlyEfka), round2(monthlyTax),
                round2(effRate), round2(monthlyGross + efkaEmployer), round2(efkaEmployer));
    }

    /** Convenience overload — adult (age ≥31) scale. */
    public static double netToGross(double targetNet, int children, int months, boolean disability) {
        return netToGross(targetNet, children, months, disability, 0);
    }

    /** Inverse of {@link #grossToNet} via bisection (the net→gross function is monotonic). */
    public static double netToGross(double targetNet, int children, int months, boolean disability, int age) {
        if (targetNet <= 0) {
            throw new IllegalArgumentException("targetNet must be > 0");
        }
        double lo = targetNet;
        double hi = targetNet / (1 - EFKA_EMPLOYEE_RATE - 0.44); // safe upper bound (max marginal load)
        for (int i = 0; i < 100; i++) {
            double mid = (lo + hi) / 2;
            double net = grossToNet(mid, children, months, disability, age).netMonthly();
            if (Math.abs(net - targetNet) < 0.005) {
                return round2(mid);
            }
            if (net < targetNet) {
                lo = mid;
            } else {
                hi = mid;
            }
        }
        return round2((lo + hi) / 2);
    }

    // ---- Overtime ----

    public static OvertimeResult overtime(double monthlySalary, double hourlyWage, double hours,
                                          OvertimeType type, boolean sunday, boolean night, boolean sixDay) {
        if (hours <= 0) {
            throw new IllegalArgumentException("hours must be > 0");
        }
        double hourly = resolveHourly(monthlySalary, hourlyWage, sixDay);
        double surcharge = type.rate + (sunday ? 0.75 : 0) + (night ? 0.25 : 0);
        double base = hourly * hours;
        double surchargeAmount = base * surcharge;
        return new OvertimeResult(round2(hourly), round2(base), round2(surchargeAmount),
                round2(base + surchargeAmount), Math.round(surcharge * 100));
    }

    // ---- Night work (22:00–06:00) ----

    public static NightWorkResult nightWork(double monthlySalary, double hourlyWage, double hours,
                                            boolean sundayOrHoliday, boolean sixDay) {
        if (hours <= 0) {
            throw new IllegalArgumentException("hours must be > 0");
        }
        double hourly = resolveHourly(monthlySalary, hourlyWage, sixDay);
        double surcharge = 0.25 + (sundayOrHoliday ? 0.75 : 0); // weekday night +25%; Sunday/holiday night stacks to +100%
        double base = hourly * hours;
        double allowance = base * surcharge;
        return new NightWorkResult(round2(hourly), round2(base), round2(allowance),
                round2(base + allowance), Math.round(surcharge * 100));
    }

    /**
     * Full overtime/surcharge rate table for a salary (what the UI dialog displays).
     *
     * <p><b>Night-premium base (intentional mix):</b> the +25% night increment is reckoned on the
     * <i>legal/minimum</i> hourly wage ({@code legalMonthlySalary} — the ΣΕΠΕ basis for the night
     * allowance), while the overtime premiums use the worker's <i>actual</i> hourly wage. So when
     * {@code legalMonthlySalary} differs from {@code monthlySalary}, {@code totalNightRate}
     * (= actual hourly + legal-based night increment) deliberately mixes the two bases. When
     * {@code legalMonthlySalary} is omitted (0) it falls back to the actual wage and the bases coincide.
     */
    public static OvertimeRatesResult overtimeRates(double monthlySalary, double hourlyWage,
                                                    double legalMonthlySalary, boolean sixDay) {
        double hourly = resolveHourly(monthlySalary, hourlyWage, sixDay);
        double legalHourly = legalMonthlySalary > 0 ? resolveHourly(legalMonthlySalary, 0, sixDay) : hourly;
        double nightIncrement = legalHourly * 0.25;   // night +25% on the legal/min wage (see javadoc)
        return new OvertimeRatesResult(
                round2(hourly),
                round2(hourly * 1.20),   // υπερεργασία +20%
                round2(hourly * 1.40),   // νόμιμη υπερωρία ≤150h/yr +40%
                round2(hourly * 1.60),   // νόμιμη υπερωρία >150h/yr +60%
                round2(hourly * 2.20),   // παράνομη υπερωρία +120%
                round2(nightIncrement),
                round2(hourly + nightIncrement),   // actual hourly + legal-based night increment (mixed base, intentional)
                round2(hourly * 1.30),   // 6η ημέρα +30% (per hour)
                round2(hourly * 1.40));  // 6η ημέρα συνεχούς λειτουργίας +40% (per hour)
    }

    /** Legal hourly wage = monthlySalary × 0.006 (the ΣΕΠΕ/KEPEA ωρομίσθιο); or the explicit hourly wage. */
    private static double resolveHourly(double monthlySalary, double hourlyWage, boolean sixDay) {
        if (hourlyWage > 0) {
            return hourlyWage;
        }
        if (monthlySalary <= 0) {
            throw new IllegalArgumentException("either monthlySalary or hourlyWage must be > 0");
        }
        return monthlySalary * LEGAL_HOURLY_FACTOR;
    }
}

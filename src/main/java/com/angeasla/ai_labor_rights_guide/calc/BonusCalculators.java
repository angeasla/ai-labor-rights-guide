package com.angeasla.ai_labor_rights_guide.calc;

import static com.angeasla.ai_labor_rights_guide.calc.CalcConstants.LEAVE_INCREMENT;
import static com.angeasla.ai_labor_rights_guide.calc.CalcConstants.round2;

/**
 * Holiday bonuses (δώρα): Easter (ΑΝ 435/1968) and Christmas (ΑΝ 682/1945), per ΚΥΑ 19040/1981.
 * Every variant adds the mandatory leave-pay increment (×(1 + 1/24)). Verified in CALCULATOR_SPECS.md.
 * Day counts are passed in (the tool/REST layer derives them from the period dates).
 */
public final class BonusCalculators {

    private BonusCalculators() {
    }

    private static final int EASTER_FULL_DAYS = 120;   // 15 daily-wage blocks × 8
    private static final int EASTER_BLOCK = 8;
    private static final double EASTER_MAX_UNITS = 15;
    private static final int XMAS_FULL_DAYS = 245;      // calendar days May 1–Dec 31 (full-period gate)
    private static final int XMAS_BLOCK = 19;
    private static final double XMAS_MAX_UNITS = 25;

    public record BonusResult(double amount, double base, double units) {
    }

    private static BonusResult withIncrement(double base, double units) {
        return new BonusResult(round2(base * (1 + LEAVE_INCREMENT)), round2(base), round2(units));
    }

    // ---- Easter (period 1 Jan – 30 Apr) ----

    /** Salaried: full bonus = ½ monthly salary, prorated by worked days over 120. */
    public static BonusResult easterSalaried(double monthlySalary, int workedDays) {
        double ratio = Math.min(workedDays / (double) EASTER_FULL_DAYS, 1.0);
        double base = monthlySalary * 0.5 * ratio;
        return withIncrement(base, ratio * EASTER_MAX_UNITS);
    }

    /** Daily-paid / part-time: 1 daily wage per 8-day block (cap 15 units). */
    public static BonusResult easterDaily(double dailyWage, int workedDays) {
        double units = Math.min(workedDays / (double) EASTER_BLOCK, EASTER_MAX_UNITS);
        return withIncrement(dailyWage * units, units);
    }

    /** Hourly / variable: average daily wage × (calendar days / 8) (cap 15 units). */
    public static BonusResult easterHourly(double totalEarnings, int actualDaysWorked, int calendarDays) {
        if (actualDaysWorked <= 0) {
            return new BonusResult(0, 0, 0);
        }
        double avg = totalEarnings / actualDaysWorked;
        double units = Math.min(calendarDays / (double) EASTER_BLOCK, EASTER_MAX_UNITS);
        return withIncrement(avg * units, units);
    }

    // ---- Christmas (period 1 May – 31 Dec) ----

    /** Salaried: full period → 1 monthly salary; else 2/25 of salary per 19-day block. */
    public static BonusResult christmasSalaried(double monthlySalary, int workedDays) {
        if (workedDays >= XMAS_FULL_DAYS) {
            return withIncrement(monthlySalary, XMAS_MAX_UNITS);
        }
        double units = Math.min((workedDays / (double) XMAS_BLOCK) * 2, XMAS_MAX_UNITS);
        // Cap the base at one monthly salary so the 238–244-day band can't exceed the full-period bonus.
        double base = Math.min((workedDays / (double) XMAS_BLOCK) * (monthlySalary * 2.0 / 25.0), monthlySalary);
        return withIncrement(base, units);
    }

    /** Daily-paid / part-time: 2 daily wages per 19-day block (cap 25 units). */
    public static BonusResult christmasDaily(double dailyWage, int workedDays) {
        double units = Math.min((workedDays / (double) XMAS_BLOCK) * 2, XMAS_MAX_UNITS);
        return withIncrement(dailyWage * units, units);
    }

    /** Hourly / variable: average daily wage × units (25 if full period, else 2 per 19-day block). */
    public static BonusResult christmasHourly(double totalEarnings, int actualDaysWorked, int calendarDays) {
        if (actualDaysWorked <= 0) {
            return new BonusResult(0, 0, 0);
        }
        double avg = totalEarnings / actualDaysWorked;
        double units = (calendarDays >= XMAS_FULL_DAYS)
                ? XMAS_MAX_UNITS
                : Math.min((calendarDays / (double) XMAS_BLOCK) * 2, XMAS_MAX_UNITS);
        return withIncrement(avg * units, units);
    }
}

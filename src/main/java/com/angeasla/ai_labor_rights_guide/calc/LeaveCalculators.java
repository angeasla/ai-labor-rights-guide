package com.angeasla.ai_labor_rights_guide.calc;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import static com.angeasla.ai_labor_rights_guide.calc.CalcConstants.round2;

/**
 * Leave calculators: annual leave days, part-time leave, leave pay + bonus, maternity reduced-hours equivalent.
 * Verified against Greek law in CALCULATOR_SPECS.md.
 */
public final class LeaveCalculators {

    private LeaveCalculators() {
    }

    public enum PayType {SALARY, DAILY_WAGE}

    public record LeaveDaysResult(int days) {
    }

    public record PartTimeLeaveResult(int days, double exactDays) {
    }

    public record LeavePayResult(double paidDays, double leavePay, double leaveBonus, double total, boolean capHit) {
    }

    public record MaternityResult(double workingDays, double hoursOwed, double continuousDays,
                                  double continuousMonths, LocalDate windowEnd) {
    }

    // ---- Annual leave days (ΑΝ 539/1945 + Ν.3302/2004 + EGSSE) ----

    /** Two-layer max model: base statutory ladder vs the EGSSE tenure tiers. */
    public static LeaveDaysResult leaveDays(int workWeek, int tenureMonths, int totalCareerYears) {
        int base = (workWeek == 6) ? 24 : 20;
        int baseLadder;
        if (tenureMonths < 12) {
            baseLadder = (int) Math.round((tenureMonths / 12.0) * base);
        } else if (tenureMonths / 12 == 1) {
            baseLadder = base + 1;                       // 21 / 25
        } else {
            baseLadder = (workWeek == 6) ? 26 : 22;      // ≥2 completed years
        }
        int egsse = 0;
        if (tenureMonths >= 120 || totalCareerYears >= 12) {
            egsse = (workWeek == 6) ? 30 : 25;
        }
        if (totalCareerYears >= 25) {
            egsse = (workWeek == 6) ? 31 : 26;
        }
        return new LeaveDaysResult(Math.max(baseLadder, egsse));
    }

    /** Convenience overload: derive tenure months from hire/reference dates. */
    public static LeaveDaysResult leaveDays(int workWeek, LocalDate hireDate, LocalDate refDate, int totalCareerYears) {
        long months = Math.max(0, ChronoUnit.MONTHS.between(hireDate, refDate));
        return leaveDays(workWeek, (int) months, totalCareerYears);
    }

    // ---- Part-time annual leave (ratio model) ----

    public static PartTimeLeaveResult partTimeLeave(int fullTimeDays, double ptRatio) {
        double ratio = Math.max(0, Math.min(1.0, ptRatio));
        double exact = fullTimeDays * ratio;
        int days = (int) Math.min(fullTimeDays, Math.round(exact));
        return new PartTimeLeaveResult(days, exact);
    }

    // ---- Leave pay + leave bonus (αποδοχές & επίδομα αδείας) ----

    public static LeavePayResult leavePay(PayType type, double amount, int leaveDays, int workWeek) {
        if (amount <= 0) {
            throw new IllegalArgumentException("amount must be > 0");
        }
        double paidDays = (workWeek == 5) ? leaveDays * 1.2 : leaveDays;
        double leavePay;
        double cap;
        if (type == PayType.SALARY) {
            leavePay = paidDays * (amount / 25.0);
            cap = amount * 0.5;
        } else {
            leavePay = paidDays * amount;
            cap = amount * 13.0;
        }
        double bonus = Math.min(leavePay, cap);
        boolean capHit = leavePay > cap;
        return new LeavePayResult(round2(paidDays), round2(leavePay), round2(bonus), round2(leavePay + bonus), capHit);
    }

    // ---- Maternity reduced-hours equivalent (ισόχρονη άδεια) ----

    /**
     * Continuous-leave equivalent of the 30-month one-hour daily reduction (Ν.1483/1984, Ν.4808/2021).
     * Result is an estimate and an employer-agreement option, not an automatic right (see CALCULATOR_SPECS.md).
     */
    public static MaternityResult maternity(LocalDate windowStart, int workWeek, int annualLeaveDays,
                                            int multipleBirthExtraChildren) {
        int windowMonths = 30 + 6 * Math.max(0, multipleBirthExtraChildren);
        LocalDate windowEnd = windowStart.plusMonths(windowMonths);

        int workingDays = 0;
        for (LocalDate d = windowStart; d.isBefore(windowEnd); d = d.plusDays(1)) {
            DayOfWeek dow = d.getDayOfWeek();
            boolean weekend = (workWeek == 5)
                    ? (dow == DayOfWeek.SATURDAY || dow == DayOfWeek.SUNDAY)
                    : (dow == DayOfWeek.SUNDAY);
            if (!weekend && !isPublicHoliday(d)) {
                workingDays++;
            }
        }
        workingDays -= (int) Math.round(annualLeaveDays * (windowMonths / 12.0));
        if (workingDays < 0) {
            workingDays = 0;
        }
        double hoursOwed = workingDays; // 1 hour per working day
        double divisor = (workWeek == 6) ? (40.0 / 6.0) : 8.0;
        double continuousDays = Math.round(hoursOwed / divisor);
        double continuousMonths = round2(continuousDays / 25.0);
        return new MaternityResult(workingDays, hoursOwed, continuousDays, continuousMonths, windowEnd);
    }

    /** Greek statutory public holidays (fixed + Orthodox-Easter-relative movable feasts). */
    static boolean isPublicHoliday(LocalDate d) {
        int m = d.getMonthValue();
        int day = d.getDayOfMonth();
        if ((m == 1 && day == 1) || (m == 1 && day == 6) || (m == 3 && day == 25)
                || (m == 5 && day == 1) || (m == 8 && day == 15) || (m == 10 && day == 28)
                || (m == 12 && day == 25) || (m == 12 && day == 26)) {
            return true;
        }
        LocalDate easter = EasterDate.orthodoxEaster(d.getYear());
        return d.equals(easter.minusDays(48))   // Clean Monday
                || d.equals(easter.minusDays(2)) // Good Friday
                || d.equals(easter.plusDays(1))  // Easter Monday
                || d.equals(easter.plusDays(50)); // Holy Spirit Monday
    }
}

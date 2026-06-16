package com.angeasla.ai_labor_rights_guide.calc;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static com.angeasla.ai_labor_rights_guide.calc.LeaveCalculators.PayType.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Verified-spec tests for the leave, bonus and date calculators (CALCULATOR_SPECS.md, Greek law 2026).
 * Bonus vectors use clean inputs that yield exact decimals; to be re-locked against KEPEA.
 */
class LeaveBonusCalculatorTest {

    private static final double EPS = 0.01;

    // ---- Annual leave days ----

    @Test
    void leaveDays_vectors() {
        assertEquals(10, LeaveCalculators.leaveDays(5, 6, 0).days());
        assertEquals(21, LeaveCalculators.leaveDays(5, 15, 1).days());
        assertEquals(22, LeaveCalculators.leaveDays(5, 48, 4).days());
        assertEquals(30, LeaveCalculators.leaveDays(6, 132, 11).days());   // EGSSE 6-day tier
        assertEquals(26, LeaveCalculators.leaveDays(5, 36, 26).days());    // ≥25 career years
    }

    // ---- Part-time leave ----

    @Test
    void partTimeLeave_vectors() {
        assertEquals(11, LeaveCalculators.partTimeLeave(22, 0.5).days());
        assertEquals(11, LeaveCalculators.partTimeLeave(21, 0.5).days());  // 10.5 → half-up 11
        assertEquals(15, LeaveCalculators.partTimeLeave(25, 0.6).days());
        assertEquals(17, LeaveCalculators.partTimeLeave(22, 0.75).days()); // 16.5 → 17
        assertEquals(8, LeaveCalculators.partTimeLeave(20, 0.4).days());
    }

    // ---- Leave pay + bonus ----

    @Test
    void leavePay_vectors() {
        var v1 = LeaveCalculators.leavePay(SALARY, 1200, 20, 5);
        assertEquals(1152.00, v1.leavePay(), EPS);
        assertEquals(600.00, v1.leaveBonus(), EPS);
        assertEquals(1752.00, v1.total(), EPS);

        var v3 = LeaveCalculators.leavePay(SALARY, 1500, 4, 5); // cap not hit
        assertEquals(288.00, v3.leaveBonus(), EPS);
        assertEquals(576.00, v3.total(), EPS);

        var v5 = LeaveCalculators.leavePay(DAILY_WAGE, 50, 24, 6);
        assertEquals(1200.00, v5.leavePay(), EPS);
        assertEquals(650.00, v5.leaveBonus(), EPS);
        assertEquals(1850.00, v5.total(), EPS);
    }

    // ---- Easter bonus (factor 25/24) ----

    @Test
    void easterBonus_vectors() {
        assertEquals(520.83, BonusCalculators.easterSalaried(1000, 120).amount(), EPS); // full
        assertEquals(260.42, BonusCalculators.easterSalaried(1000, 60).amount(), EPS);  // half
        assertEquals(750.00, BonusCalculators.easterDaily(48, 120).amount(), EPS);      // 15 units
        assertEquals(400.00, BonusCalculators.easterDaily(48, 64).amount(), EPS);       // 8 units
        assertEquals(750.00, BonusCalculators.easterHourly(1440, 30, 120).amount(), EPS);

        // Leap year (2024): Jan 1–Apr 30 = 121 days, so 120 worked days is just under full.
        assertEquals(516.53, BonusCalculators.easterSalaried(1000, 120, 2024).amount(), EPS);
        assertEquals(520.83, BonusCalculators.easterSalaried(1000, 121, 2024).amount(), EPS); // full leap period
    }

    // ---- Christmas bonus (/19 rule) ----

    @Test
    void christmasBonus_vectors() {
        assertEquals(1000.00, BonusCalculators.christmasSalaried(960, 245).amount(), EPS); // full period
        assertEquals(400.00, BonusCalculators.christmasSalaried(960, 95).amount(), EPS);   // 5 blocks
        assertEquals(1250.00, BonusCalculators.christmasDaily(48, 245).amount(), EPS);     // cap 25 units
        assertEquals(500.00, BonusCalculators.christmasDaily(48, 95).amount(), EPS);       // 10 units
        assertEquals(1250.00, BonusCalculators.christmasHourly(1440, 30, 245).amount(), EPS);
        assertEquals(500.00, BonusCalculators.christmasHourly(1440, 30, 95).amount(), EPS);   // partial: 10 units
    }

    // ---- Orthodox Easter date ----

    @Test
    void orthodoxEaster_dates() {
        assertEquals(LocalDate.of(2024, 5, 5), EasterDate.orthodoxEaster(2024));
        assertEquals(LocalDate.of(2025, 4, 20), EasterDate.orthodoxEaster(2025));
        assertEquals(LocalDate.of(2026, 4, 12), EasterDate.orthodoxEaster(2026));
        assertEquals(LocalDate.of(2027, 5, 2), EasterDate.orthodoxEaster(2027));
        assertEquals(LocalDate.of(2031, 4, 13), EasterDate.orthodoxEaster(2031));
    }

    @Test
    void greekHolidays_detected() {
        assertTrue(LeaveCalculators.isPublicHoliday(LocalDate.of(2026, 1, 1)));   // New Year
        assertTrue(LeaveCalculators.isPublicHoliday(LocalDate.of(2026, 2, 23)));  // Clean Monday (Easter-48)
        assertTrue(LeaveCalculators.isPublicHoliday(LocalDate.of(2026, 4, 10)));  // Good Friday (Easter-2)
        assertTrue(LeaveCalculators.isPublicHoliday(LocalDate.of(2026, 4, 13)));  // Easter Monday (Easter+1)
        assertTrue(LeaveCalculators.isPublicHoliday(LocalDate.of(2026, 6, 1)));   // Holy Spirit (Easter+50)
        assertFalse(LeaveCalculators.isPublicHoliday(LocalDate.of(2026, 4, 12))); // Easter Sunday itself isn't listed
        assertFalse(LeaveCalculators.isPublicHoliday(LocalDate.of(2026, 7, 15)));
    }

    // ---- Maternity (estimate; loose bounds + invariants) ----

    @Test
    void maternity_reasonable() {
        var r = LeaveCalculators.maternity(LocalDate.of(2026, 1, 1), 5, 22, 0);
        assertEquals(LocalDate.of(2028, 7, 1), r.windowEnd());
        assertTrue(r.continuousDays() >= 60 && r.continuousDays() <= 90,
                "expected ~3.5 months (5-day), got " + r.continuousDays());
        // twins extend the window by 6 months → more owed time
        var twins = LeaveCalculators.maternity(LocalDate.of(2026, 1, 1), 5, 22, 1);
        assertTrue(twins.continuousDays() > r.continuousDays());
    }
}

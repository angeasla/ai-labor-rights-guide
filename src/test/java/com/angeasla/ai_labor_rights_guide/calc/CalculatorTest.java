package com.angeasla.ai_labor_rights_guide.calc;

import org.junit.jupiter.api.Test;

import static com.angeasla.ai_labor_rights_guide.calc.WageCalculators.OvertimeType.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Verified-spec tests for the labor-law calculators. Expected values are from CALCULATOR_SPECS.md
 * (Greek law, 2026), NOT copied from the legacy Angular/Node implementations. To be re-locked against
 * the KEPEA online calculators once credentials are available.
 */
class CalculatorTest {

    private static final double EPS = 0.01;

    // ---- Gross → Net (2026 brackets) ----

    @Test
    void grossToNet_vectors() {
        var v1 = WageCalculators.grossToNet(920, 0, 14, false);
        assertEquals(771.67, v1.netMonthly(), EPS);
        assertEquals(123.00, v1.efkaEmployee(), EPS);
        assertEquals(25.33, v1.incomeTaxMonthly(), EPS);

        var v2 = WageCalculators.grossToNet(1500, 0, 14, false);
        assertEquals(1164.79, v2.netMonthly(), EPS);
        assertEquals(200.55, v2.efkaEmployee(), EPS);
        assertEquals(134.66, v2.incomeTaxMonthly(), EPS);

        var v3 = WageCalculators.grossToNet(2500, 2, 14, false);
        assertEquals(1876.08, v3.netMonthly(), EPS);   // 2026: 2 children cut the 10-20k (16%) + 20-30k (22%) bands
        assertEquals(289.67, v3.incomeTaxMonthly(), EPS);

        var v4 = WageCalculators.grossToNet(5000, 0, 12, false);
        assertEquals(3200.55, v4.netMonthly(), EPS);
        assertEquals(1130.95, v4.incomeTaxMonthly(), EPS);
    }

    @Test
    void netToGross_inverts() {
        double gross = WageCalculators.netToGross(1000, 0, 14, false);
        assertEquals(1000, WageCalculators.grossToNet(gross, 0, 14, false).netMonthly(), EPS);
    }

    @Test
    void grossToNet_rejectsNonPositive() {
        assertThrows(IllegalArgumentException.class, () -> WageCalculators.grossToNet(0, 0, 14, false));
    }

    @Test
    void grossToNet_childAndAgeDependent_2026() {
        // 3 children (age ≥31): 10-20k drops to 9%, 20-30k to 20%.
        var fam = WageCalculators.grossToNet(2000, 3, 14, false, 35);
        assertEquals(1621.43, fam.netMonthly(), EPS);
        assertEquals(111.17, fam.incomeTaxMonthly(), EPS);

        // Age ≤25: first two bands 0% → no income tax at €1500.
        var youth = WageCalculators.grossToNet(1500, 0, 14, false, 24);
        assertEquals(0.00, youth.incomeTaxMonthly(), EPS);
        assertEquals(1299.45, youth.netMonthly(), EPS);

        // Age 26-30: first two bands 9%.
        var youngAdult = WageCalculators.grossToNet(2000, 0, 14, false, 28);
        assertEquals(169.63, youngAdult.incomeTaxMonthly(), EPS);
        assertEquals(1562.97, youngAdult.netMonthly(), EPS);
    }

    // ---- Overtime ----

    @Test
    void overtime_vectors() {
        // hourly = salary × 0.006 (legal ωρομίσθιο)
        assertEquals(33.12, WageCalculators.overtime(920, 0, 5, OVERWORK, false, false, false).total(), EPS);
        assertEquals(84.00, WageCalculators.overtime(1000, 0, 10, LEGAL, false, false, false).total(), EPS);
        assertEquals(158.40, WageCalculators.overtime(1500, 0, 8, ILLEGAL, false, false, false).total(), EPS);
        assertEquals(96.00, WageCalculators.overtime(1000, 0, 10, LEGAL_OVER_150, false, false, false).total(), EPS); // >150h/yr +60%
        assertEquals(71.28, WageCalculators.overtime(1200, 0, 6, LEGAL, false, true, false).total(), EPS);
        assertEquals(4.29, WageCalculators.overtime(0, 4.40, 0.5, OVERWORK, true, false, false).total(), EPS); // explicit hourly
    }

    @Test
    void overtime_rejectsZeroHours() {
        assertThrows(IllegalArgumentException.class,
                () -> WageCalculators.overtime(1000, 0, 0, LEGAL, false, false, false));
    }

    @Test
    void overtimeRates_table() {
        // matches KEPEA's per-hour table for €1000 salaried (×0.006 base)
        var r = WageCalculators.overtimeRates(1000, 0, 1000, false);
        assertEquals(6.00, r.hourlyRate(), EPS);
        assertEquals(7.20, r.overwork(), EPS);
        assertEquals(8.40, r.legalOvertime(), EPS);
        assertEquals(9.60, r.legalOvertimeOver150(), EPS);
        assertEquals(13.20, r.illegalOvertime(), EPS);
        assertEquals(7.50, r.totalNightRate(), EPS);
        assertEquals(7.80, r.sixthDayStandard(), EPS);
        assertEquals(8.40, r.sixthDayShift(), EPS);
    }

    // ---- Night work ----

    @Test
    void nightWork_vectors() {
        // hourly = salary × 0.006 (legal ωρομίσθιο)
        assertEquals(55.20, WageCalculators.nightWork(920, 0, 8, false, false).total(), EPS);
        assertEquals(60.00, WageCalculators.nightWork(1000, 0, 8, false, false).total(), EPS);
        assertEquals(96.00, WageCalculators.nightWork(1000, 0, 8, true, false).total(), EPS); // Sunday night stacks to +100%
        assertEquals(68.25, WageCalculators.nightWork(1400, 0, 6.5, false, false).total(), EPS);
        assertEquals(17.60, WageCalculators.nightWork(0, 4.40, 2, true, false).total(), EPS); // explicit hourly
    }

    // ---- Severance (ladder to 12 months) ----

    @Test
    void severance_vectors() {
        assertEquals(2333.33, SeveranceCalculator.severance(1000, 3, false).amount(), EPS);
        assertEquals(1166.67, SeveranceCalculator.severance(1000, 3, true).amount(), EPS);
        assertEquals(10500.00, SeveranceCalculator.severance(1500, 10, false).amount(), EPS);
        assertEquals(28000.00, SeveranceCalculator.severance(2000, 16, false).amount(), EPS); // 12-month cap
        assertEquals(0.00, SeveranceCalculator.severance(830, 0, false).amount(), EPS);
    }

    // ---- National pension ----

    @Test
    void nationalPension_vectors() {
        assertEquals(446.86, PensionCalculators.nationalPension(20, 40, 67).monthlyAmount(), EPS);
        assertEquals(402.17, PensionCalculators.nationalPension(15, 40, 67).monthlyAmount(), EPS);
        assertEquals(420.05, PensionCalculators.nationalPension(17, 40, 67).monthlyAmount(), EPS);
        assertEquals(335.15, PensionCalculators.nationalPension(20, 30, 67).monthlyAmount(), EPS);
        assertEquals(0.00, PensionCalculators.nationalPension(14, 40, 67).monthlyAmount(), EPS);
    }

    // ---- Contributory pension (Ν.4670/2020 ladder) ----

    @Test
    void contributoryPension_vectors() {
        assertEquals(115.50, PensionCalculators.contributoryPension(1000, 15).monthlyAmount(), EPS);
        assertEquals(190.44, PensionCalculators.contributoryPension(1200, 20).monthlyAmount(), EPS);
        assertEquals(395.55, PensionCalculators.contributoryPension(1500, 30).monthlyAmount(), EPS);
        assertEquals(447.72, PensionCalculators.contributoryPension(1200, 35).monthlyAmount(), EPS);
        assertEquals(1000.20, PensionCalculators.contributoryPension(2000, 40).monthlyAmount(), EPS);
    }
}

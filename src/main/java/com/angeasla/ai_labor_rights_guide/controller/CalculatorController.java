package com.angeasla.ai_labor_rights_guide.controller;

import com.angeasla.ai_labor_rights_guide.calc.*;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

/**
 * REST endpoints for the labor-law calculators. Single source of truth: every endpoint delegates to the
 * verified pure services in the {@code calc} package (same code the Spring AI tools and the JUnit tests use).
 * The Angular calculator dialogs call these instead of computing client-side.
 */
@RestController
@RequestMapping("/api/calc")
public class CalculatorController {

    @PostMapping("/gross-to-net")
    public WageCalculators.GrossToNetResult grossToNet(@RequestBody GrossToNetRequest r) {
        return WageCalculators.grossToNet(r.gross(), r.children(), r.months(), r.disability(), r.age());
    }

    @PostMapping("/net-to-gross")
    public GrossResult netToGross(@RequestBody NetToGrossRequest r) {
        return new GrossResult(WageCalculators.netToGross(r.net(), r.children(), r.months(), r.disability(), r.age()));
    }

    @PostMapping("/leave-days")
    public LeaveCalculators.LeaveDaysResult leaveDays(@RequestBody LeaveDaysRequest r) {
        return LeaveCalculators.leaveDays(r.workWeek(), r.tenureMonths(), r.totalCareerYears());
    }

    @PostMapping("/leave-part-time")
    public LeaveCalculators.PartTimeLeaveResult leavePartTime(@RequestBody PartTimeLeaveRequest r) {
        return LeaveCalculators.partTimeLeave(r.fullTimeDays(), r.ptRatio());
    }

    @PostMapping("/leave-pay")
    public LeaveCalculators.LeavePayResult leavePay(@RequestBody LeavePayRequest r) {
        return LeaveCalculators.leavePay(r.payType(), r.amount(), r.leaveDays(), r.workWeek());
    }

    @PostMapping("/severance")
    public SeveranceCalculator.SeveranceResult severance(@RequestBody SeveranceRequest r) {
        return SeveranceCalculator.severance(r.grossMonthly(), r.years(), r.withNotice());
    }

    @PostMapping("/overtime")
    public WageCalculators.OvertimeResult overtime(@RequestBody OvertimeRequest r) {
        return WageCalculators.overtime(r.monthlySalary(), r.hourlyWage(), r.hours(), r.type(), r.sunday(), r.night(), r.sixDay());
    }

    @PostMapping("/nightwork")
    public WageCalculators.NightWorkResult nightWork(@RequestBody NightWorkRequest r) {
        return WageCalculators.nightWork(r.monthlySalary(), r.hourlyWage(), r.hours(), r.sundayOrHoliday(), r.sixDay());
    }

    @PostMapping("/overtime-rates")
    public WageCalculators.OvertimeRatesResult overtimeRates(@RequestBody OvertimeRatesRequest r) {
        return WageCalculators.overtimeRates(r.monthlySalary(), r.hourlyWage(), r.legalMonthlySalary(), r.sixDay());
    }

    @PostMapping("/easter-bonus")
    public BonusCalculators.BonusResult easterBonus(@RequestBody SalariedBonusRequest r) {
        return BonusCalculators.easterSalaried(r.monthlySalary(), r.workedDays());
    }

    @PostMapping("/easter-part-time")
    public BonusCalculators.BonusResult easterPartTime(@RequestBody DailyBonusRequest r) {
        return BonusCalculators.easterDaily(r.dailyWage(), r.workedDays());
    }

    @PostMapping("/easter-hourly")
    public BonusCalculators.BonusResult easterHourly(@RequestBody HourlyBonusRequest r) {
        return BonusCalculators.easterHourly(r.totalEarnings(), r.actualDaysWorked(), r.calendarDays());
    }

    @PostMapping("/xmas-bonus")
    public BonusCalculators.BonusResult xmasBonus(@RequestBody SalariedBonusRequest r) {
        return BonusCalculators.christmasSalaried(r.monthlySalary(), r.workedDays());
    }

    @PostMapping("/xmas-part-time")
    public BonusCalculators.BonusResult xmasPartTime(@RequestBody DailyBonusRequest r) {
        return BonusCalculators.christmasDaily(r.dailyWage(), r.workedDays());
    }

    @PostMapping("/xmas-hourly")
    public BonusCalculators.BonusResult xmasHourly(@RequestBody HourlyBonusRequest r) {
        return BonusCalculators.christmasHourly(r.totalEarnings(), r.actualDaysWorked(), r.calendarDays());
    }

    @PostMapping("/maternity")
    public LeaveCalculators.MaternityResult maternity(@RequestBody MaternityRequest r) {
        return LeaveCalculators.maternity(r.windowStart(), r.workWeek(), r.annualLeaveDays(), r.multipleBirthExtraChildren());
    }

    @PostMapping("/national-pension")
    public PensionCalculators.NationalPensionResult nationalPension(@RequestBody NationalPensionRequest r) {
        return PensionCalculators.nationalPension(r.insuranceYears(), r.residenceYears(), r.retirementAge());
    }

    @PostMapping("/contributory-pension")
    public PensionCalculators.ContributoryPensionResult contributoryPension(@RequestBody ContributoryPensionRequest r) {
        return PensionCalculators.contributoryPension(r.pensionableEarnings(), r.insuranceYears());
    }

    // ---- request bodies ----

    public record GrossResult(double gross) {
    }

    public record GrossToNetRequest(double gross, int children, int months, boolean disability, int age) {
    }

    public record NetToGrossRequest(double net, int children, int months, boolean disability, int age) {
    }

    public record LeaveDaysRequest(int workWeek, int tenureMonths, int totalCareerYears) {
    }

    public record PartTimeLeaveRequest(int fullTimeDays, double ptRatio) {
    }

    public record LeavePayRequest(LeaveCalculators.PayType payType, double amount, int leaveDays, int workWeek) {
    }

    public record SeveranceRequest(double grossMonthly, int years, boolean withNotice) {
    }

    public record OvertimeRequest(double monthlySalary, double hourlyWage, double hours,
                                  WageCalculators.OvertimeType type, boolean sunday, boolean night, boolean sixDay) {
    }

    public record NightWorkRequest(double monthlySalary, double hourlyWage, double hours,
                                   boolean sundayOrHoliday, boolean sixDay) {
    }

    public record OvertimeRatesRequest(double monthlySalary, double hourlyWage,
                                       double legalMonthlySalary, boolean sixDay) {
    }

    public record SalariedBonusRequest(double monthlySalary, int workedDays) {
    }

    public record DailyBonusRequest(double dailyWage, int workedDays) {
    }

    public record HourlyBonusRequest(double totalEarnings, int actualDaysWorked, int calendarDays) {
    }

    public record MaternityRequest(LocalDate windowStart, int workWeek, int annualLeaveDays,
                                   int multipleBirthExtraChildren) {
    }

    public record NationalPensionRequest(int insuranceYears, int residenceYears, int retirementAge) {
    }

    public record ContributoryPensionRequest(double pensionableEarnings, int insuranceYears) {
    }
}

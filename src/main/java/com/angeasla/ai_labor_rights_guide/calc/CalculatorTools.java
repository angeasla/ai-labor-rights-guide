package com.angeasla.ai_labor_rights_guide.calc;

import org.springframework.ai.tool.annotation.Tool;
import org.springframework.ai.tool.annotation.ToolParam;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

/**
 * Spring AI tool wrappers over the verified calculator services. Registered on the ChatClient so the LLM
 * performs real function-calling instead of doing math by hand. Descriptions are in Greek and use the
 * mandatory phrasing "Χρησιμοποίησε ΠΑΝΤΑ ... μην υπολογίζεις εσύ" — preserve this.
 */
@Component
public class CalculatorTools {

    @Tool(description = "Υπολογίζει τον καθαρό μηνιαίο μισθό από τον μεικτό (φορολογικές κλίμακες 2026, ΕΦΚΑ, έκπτωση φόρου τέκνων). Χρησιμοποίησε ΠΑΝΤΑ αυτό το εργαλείο για ερωτήσεις περί καθαρού/μεικτού μισθού — μην υπολογίζεις εσύ.")
    public WageCalculators.GrossToNetResult grossToNet(
            @ToolParam(description = "Μεικτός μηνιαίος μισθός σε ευρώ") double gross,
            @ToolParam(description = "Αριθμός εξαρτώμενων τέκνων (0 αν δεν υπάρχουν)") int children,
            @ToolParam(description = "Μήνες αποδοχών: 14 (με δώρα) ή 12") int months,
            @ToolParam(description = "Αναπηρία ≥67% (προσθέτει έκπτωση φόρου €200)") boolean disability,
            @ToolParam(description = "Ηλικία εργαζομένου — φοροαπαλλαγή νέων 2026: ≤25 αφορολόγητο έως 20.000€, 26–30 με 9% στα πρώτα 20.000€. Για >30 ετών ή άγνωστη ηλικία βάλε 35.") int age) {
        return WageCalculators.grossToNet(gross, children, months, disability, age);
    }

    @Tool(description = "Υπολογίζει τον μεικτό μισθό που αντιστοιχεί σε έναν επιθυμητό καθαρό μισθό. Χρησιμοποίησε ΠΑΝΤΑ αυτό το εργαλείο — μην υπολογίζεις εσύ.")
    public double netToGross(
            @ToolParam(description = "Επιθυμητός καθαρός μηνιαίος μισθός σε ευρώ") double net,
            @ToolParam(description = "Αριθμός εξαρτώμενων τέκνων") int children,
            @ToolParam(description = "Μήνες αποδοχών: 14 ή 12") int months,
            @ToolParam(description = "Αναπηρία ≥67%") boolean disability,
            @ToolParam(description = "Ηλικία εργαζομένου (φοροαπαλλαγή νέων 2026). Για >30 ετών ή άγνωστη βάλε 35.") int age) {
        return WageCalculators.netToGross(net, children, months, disability, age);
    }

    @Tool(description = "Υπολογίζει τις ημέρες ετήσιας άδειας (ΑΝ 539/1945 + ΕΓΣΣΕ). Χρησιμοποίησε ΠΑΝΤΑ αυτό το εργαλείο για ερωτήσεις περί ημερών άδειας — μην υπολογίζεις εσύ.")
    public LeaveCalculators.LeaveDaysResult leaveDays(
            @ToolParam(description = "Ημέρες εργασίας ανά εβδομάδα: 5 ή 6") int workWeek,
            @ToolParam(description = "Μήνες προϋπηρεσίας στον τρέχοντα εργοδότη") int tenureMonths,
            @ToolParam(description = "Συνολικά έτη καριέρας σε όλους τους εργοδότες") int totalCareerYears) {
        return LeaveCalculators.leaveDays(workWeek, tenureMonths, totalCareerYears);
    }

    @Tool(description = "Υπολογίζει ημέρες άδειας για μερική/εκ περιτροπής απασχόληση (αναλογικά). Χρησιμοποίησε ΠΑΝΤΑ αυτό το εργαλείο — μην υπολογίζεις εσύ.")
    public LeaveCalculators.PartTimeLeaveResult leavePartTime(
            @ToolParam(description = "Ημέρες άδειας πλήρους απασχόλησης για την ίδια προϋπηρεσία") int fullTimeDays,
            @ToolParam(description = "Λόγος μερικής απασχόλησης = ώρες μερικής / ώρες πλήρους (0–1)") double ptRatio) {
        return LeaveCalculators.partTimeLeave(fullTimeDays, ptRatio);
    }

    @Tool(description = "Υπολογίζει τις αποδοχές και το επίδομα αδείας. Χρησιμοποίησε ΠΑΝΤΑ αυτό το εργαλείο — μην υπολογίζεις εσύ.")
    public LeaveCalculators.LeavePayResult leavePay(
            @ToolParam(description = "Τύπος αμοιβής: SALARY (μισθωτός) ή DAILY_WAGE (ημερομίσθιος)") LeaveCalculators.PayType payType,
            @ToolParam(description = "Μηνιαίος μισθός ή ημερομίσθιο σε ευρώ") double amount,
            @ToolParam(description = "Ημέρες άδειας") int leaveDays,
            @ToolParam(description = "Ημέρες εργασίας ανά εβδομάδα: 5 ή 6") int workWeek) {
        return LeaveCalculators.leavePay(payType, amount, leaveDays, workWeek);
    }

    @Tool(description = "Υπολογίζει αποζημίωση απόλυσης (Ν.2112/1920, Ν.4093/2012). Χρησιμοποίησε ΠΑΝΤΑ αυτό το εργαλείο για ερωτήσεις περί αποζημίωσης — μην υπολογίζεις εσύ.")
    public SeveranceCalculator.SeveranceResult severance(
            @ToolParam(description = "Μεικτός μηνιαίος μισθός σε ευρώ") double grossMonthly,
            @ToolParam(description = "Συμπληρωμένα έτη υπηρεσίας στον εργοδότη") int years,
            @ToolParam(description = "true αν δόθηκε έγκυρη προειδοποίηση (τακτική καταγγελία) → 50% αποζημίωση") boolean withNotice) {
        return SeveranceCalculator.severance(grossMonthly, years, withNotice);
    }

    @Tool(description = "Υπολογίζει υπερωριακή αμοιβή (Ν.4808/2021, Ν.5053/2023). Χρησιμοποίησε ΠΑΝΤΑ αυτό το εργαλείο για ερωτήσεις περί υπερεργασίας/υπερωριών — μην υπολογίζεις εσύ.")
    public WageCalculators.OvertimeResult overtime(
            @ToolParam(description = "Μεικτός μηνιαίος μισθός σε ευρώ (αν δεν δίνεται ωρομίσθιο)") double monthlySalary,
            @ToolParam(description = "Ωρομίσθιο σε ευρώ (0 αν δίνεται μηνιαίος μισθός)") double hourlyWage,
            @ToolParam(description = "Αριθμός ωρών") double hours,
            @ToolParam(description = "Κατηγορία: OVERWORK (υπερεργασία +20%), LEGAL (νόμιμη υπερωρία ≤150 ώρες/έτος +40%), LEGAL_OVER_150 (νόμιμη υπερωρία >150 ώρες/έτος +60%), ILLEGAL (παράνομη +120%)") WageCalculators.OvertimeType type,
            @ToolParam(description = "true αν Κυριακή/αργία (+75% επιπλέον)") boolean sunday,
            @ToolParam(description = "true αν νυχτερινή εργασία (+25% επιπλέον)") boolean night,
            @ToolParam(description = "true αν εξαήμερο") boolean sixDay) {
        return WageCalculators.overtime(monthlySalary, hourlyWage, hours, type, sunday, night, sixDay);
    }

    @Tool(description = "Υπολογίζει νυχτερινή αμοιβή (22:00–06:00, +25%· Κυριακή/αργία +100%). Χρησιμοποίησε ΠΑΝΤΑ αυτό το εργαλείο για ερωτήσεις περί νυχτερινών — μην υπολογίζεις εσύ.")
    public WageCalculators.NightWorkResult nightWork(
            @ToolParam(description = "Μεικτός μηνιαίος μισθός σε ευρώ (αν δεν δίνεται ωρομίσθιο)") double monthlySalary,
            @ToolParam(description = "Ωρομίσθιο σε ευρώ (0 αν δίνεται μηνιαίος μισθός)") double hourlyWage,
            @ToolParam(description = "Αριθμός νυχτερινών ωρών") double hours,
            @ToolParam(description = "true αν Κυριακή/αργία") boolean sundayOrHoliday,
            @ToolParam(description = "true αν εξαήμερο") boolean sixDay) {
        return WageCalculators.nightWork(monthlySalary, hourlyWage, hours, sundayOrHoliday, sixDay);
    }

    @Tool(description = "Υπολογίζει το Δώρο Πάσχα για μισθωτό (ΑΝ 435/1968). Χρησιμοποίησε ΠΑΝΤΑ αυτό το εργαλείο — μην υπολογίζεις εσύ.")
    public BonusCalculators.BonusResult easterBonus(
            @ToolParam(description = "Μηνιαίος μισθός σε ευρώ") double monthlySalary,
            @ToolParam(description = "Ημερολογιακές ημέρες εργασίας στην περίοδο 1/1–30/4 (μέγιστο 120)") int workedDays) {
        return BonusCalculators.easterSalaried(monthlySalary, workedDays);
    }

    @Tool(description = "Υπολογίζει το Δώρο Πάσχα για ημερομίσθιο/μερικής απασχόλησης. Χρησιμοποίησε ΠΑΝΤΑ αυτό το εργαλείο — μην υπολογίζεις εσύ.")
    public BonusCalculators.BonusResult easterBonusDaily(
            @ToolParam(description = "Ημερομίσθιο σε ευρώ") double dailyWage,
            @ToolParam(description = "Ημέρες εργασίας στην περίοδο 1/1–30/4") int workedDays) {
        return BonusCalculators.easterDaily(dailyWage, workedDays);
    }

    @Tool(description = "Υπολογίζει το Δώρο Πάσχα για ωρομίσθιο/κυμαινόμενες αποδοχές. Χρησιμοποίησε ΠΑΝΤΑ αυτό το εργαλείο — μην υπολογίζεις εσύ.")
    public BonusCalculators.BonusResult easterBonusHourly(
            @ToolParam(description = "Συνολικές αποδοχές περιόδου σε ευρώ") double totalEarnings,
            @ToolParam(description = "Πραγματικές ημέρες εργασίας (για μέσο ημερομίσθιο)") int actualDaysWorked,
            @ToolParam(description = "Ημερολογιακές ημέρες σχέσης εργασίας στην περίοδο 1/1–30/4") int calendarDays) {
        return BonusCalculators.easterHourly(totalEarnings, actualDaysWorked, calendarDays);
    }

    @Tool(description = "Υπολογίζει το Δώρο Χριστουγέννων για μισθωτό (ΑΝ 682/1945). Χρησιμοποίησε ΠΑΝΤΑ αυτό το εργαλείο — μην υπολογίζεις εσύ.")
    public BonusCalculators.BonusResult christmasBonus(
            @ToolParam(description = "Μηνιαίος μισθός σε ευρώ") double monthlySalary,
            @ToolParam(description = "Ημερολογιακές ημέρες εργασίας στην περίοδο 1/5–31/12 (πλήρης περίοδος ≥245)") int workedDays) {
        return BonusCalculators.christmasSalaried(monthlySalary, workedDays);
    }

    @Tool(description = "Υπολογίζει το Δώρο Χριστουγέννων για ημερομίσθιο/μερικής απασχόλησης. Χρησιμοποίησε ΠΑΝΤΑ αυτό το εργαλείο — μην υπολογίζεις εσύ.")
    public BonusCalculators.BonusResult christmasBonusDaily(
            @ToolParam(description = "Ημερομίσθιο σε ευρώ") double dailyWage,
            @ToolParam(description = "Ημέρες εργασίας στην περίοδο 1/5–31/12") int workedDays) {
        return BonusCalculators.christmasDaily(dailyWage, workedDays);
    }

    @Tool(description = "Υπολογίζει το Δώρο Χριστουγέννων για ωρομίσθιο/κυμαινόμενες αποδοχές. Χρησιμοποίησε ΠΑΝΤΑ αυτό το εργαλείο — μην υπολογίζεις εσύ.")
    public BonusCalculators.BonusResult christmasBonusHourly(
            @ToolParam(description = "Συνολικές αποδοχές περιόδου σε ευρώ") double totalEarnings,
            @ToolParam(description = "Πραγματικές ημέρες εργασίας") int actualDaysWorked,
            @ToolParam(description = "Ημερολογιακές ημέρες σχέσης εργασίας στην περίοδο 1/5–31/12") int calendarDays) {
        return BonusCalculators.christmasHourly(totalEarnings, actualDaysWorked, calendarDays);
    }

    @Tool(description = "Υπολογίζει την ισόχρονη (συνεχόμενη) άδεια μητρότητας αντί του μειωμένου ωραρίου 30 μηνών (εκτίμηση). Χρησιμοποίησε ΠΑΝΤΑ αυτό το εργαλείο — μην υπολογίζεις εσύ.")
    public LeaveCalculators.MaternityResult maternity(
            @ToolParam(description = "Ημερομηνία έναρξης (λήξη επιδόματος μητρότητας), μορφή YYYY-MM-DD") LocalDate windowStart,
            @ToolParam(description = "Ημέρες εργασίας ανά εβδομάδα: 5 ή 6") int workWeek,
            @ToolParam(description = "Ημέρες ετήσιας άδειας της εργαζομένης") int annualLeaveDays,
            @ToolParam(description = "Επιπλέον τέκνα από πολύδυμη κύηση (0 για ένα τέκνο)") int multipleBirthExtraChildren) {
        return LeaveCalculators.maternity(windowStart, workWeek, annualLeaveDays, multipleBirthExtraChildren);
    }

    @Tool(description = "Εκτιμά την εθνική σύνταξη (Ν.4387/2016). Χρησιμοποίησε ΠΑΝΤΑ αυτό το εργαλείο για ερωτήσεις περί εθνικής σύνταξης — μην υπολογίζεις εσύ.")
    public PensionCalculators.NationalPensionResult nationalPension(
            @ToolParam(description = "Έτη ασφάλισης (ΕΦΚΑ)") int insuranceYears,
            @ToolParam(description = "Έτη μόνιμης διαμονής στην Ελλάδα (15–40)") int residenceYears,
            @ToolParam(description = "Ηλικία συνταξιοδότησης (62–67)") int retirementAge) {
        return PensionCalculators.nationalPension(insuranceYears, residenceYears, retirementAge);
    }

    @Tool(description = "Εκτιμά την ανταποδοτική σύνταξη (Ν.4670/2020). Χρησιμοποίησε ΠΑΝΤΑ αυτό το εργαλείο για ερωτήσεις περί ανταποδοτικής σύνταξης — μην υπολογίζεις εσύ.")
    public PensionCalculators.ContributoryPensionResult contributoryPension(
            @ToolParam(description = "Μέσος συντάξιμος μηνιαίος μισθός καριέρας σε ευρώ") double pensionableEarnings,
            @ToolParam(description = "Έτη ασφάλισης (ΕΦΚΑ)") int insuranceYears) {
        return PensionCalculators.contributoryPension(pensionableEarnings, insuranceYears);
    }
}

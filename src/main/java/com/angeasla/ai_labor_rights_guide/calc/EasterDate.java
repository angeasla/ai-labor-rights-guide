package com.angeasla.ai_labor_rights_guide.calc;

import java.time.LocalDate;

/**
 * Orthodox (Greek) Easter via the Meeus Julian computus, converted to the Gregorian calendar.
 * Valid for any year (the Julian→Gregorian offset is computed, not the hardcoded +13 the prototype used).
 */
public final class EasterDate {

    private EasterDate() {
    }

    /** Orthodox Easter Sunday in the Gregorian calendar for the given year. */
    public static LocalDate orthodoxEaster(int year) {
        int a = year % 4;
        int b = year % 7;
        int c = year % 19;
        int d = (19 * c + 15) % 30;
        int e = (2 * a + 4 * b - d + 34) % 7;
        int month = (d + e + 114) / 31;          // 3 = March, 4 = April (Julian)
        int day = ((d + e + 114) % 31) + 1;
        int julianToGregorian = year / 100 - year / 400 - 2; // 13 for 1900–2099, 14 for 2100s, …
        return LocalDate.of(year, month, day).plusDays(julianToGregorian);
    }
}

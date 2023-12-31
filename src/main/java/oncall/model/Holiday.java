package oncall.model;

import java.util.Arrays;
import java.util.Objects;

public enum Holiday {
    NONE("0", 0, ""),
    JANUARY("1", 1, "신정"),
    MARCH("3", 1, "삼일절"),
    MAY("5", 5, "어린이날"),
    JUNE("6", 6, "현충일"),
    AUG("8", 15, "광복절"),
    OCT1("10", 3, "개천절"),
    OCT2("10", 9, "한글날"),
    DEC("12", 25, "성탄절");

    final String month;
    final int day;
    final String holidayName;

    Holiday(String month, int day, String holidayName) {
        this.month = month;
        this.day = day;
        this.holidayName = holidayName;
    }

    public static boolean isHoliday(String monthNum, int dayNum) {
        Holiday findHoliday = Arrays.stream(Holiday.values())
                .filter(element -> Objects.equals(element.month, monthNum) && element.day == dayNum)
                .findAny()
                .orElse(NONE);
        return findHoliday != NONE;
    }
}

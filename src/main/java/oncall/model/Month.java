package oncall.model;

import java.util.Arrays;

public enum Month {
    NONE("0", 0),
    JAN("1", 31),
    FEB("2", 28),
    MAR("3", 31),
    APR("4", 30),
    MAY("5", 31),
    JUN("6", 30),
    JUL("7", 31),
    AUG("8", 31),
    SEP("9", 30),
    OCT("10", 31),
    NOV("11", 30),
    DEC("12", 31);

    String month;
    int days;

    Month(String month, int days) {
        this.month = month;
        this.days = days;
    }

    public static int getTotalDays(String month) {
        return Arrays.stream(Month.values())
                .filter(element -> element.getMonth().equals(month))
                .findAny()
                .orElse(NONE).getDays();
    }

    public String getMonth() {
        return month;
    }

    public int getDays() {
        return days;
    }
}

package oncall.model;

import java.util.List;
import oncall.utils.ConstantUtils;

public class Schedule {
    String month;
    int day;
    String dayOfWeek;
    boolean isHoliday = false;
    String worker;

    public Schedule(String month, int day, String dayOfWeek, boolean isHoliday) {
        this.month = month;
        this.day = day;
        this.dayOfWeek = dayOfWeek;
        this.isHoliday = isHoliday;
    }

    public boolean isHoliday() {
        return isHoliday;
    }

    public void setWorker(String name) {
        this.worker = name;
    }

    public boolean isWeekEnd() {
        List<String> weekEnd = List.of("토", "일");
        return weekEnd.contains(dayOfWeek);
    }

    public void printSchedule() {
        if (!isWeekEnd() && isHoliday()) {
            System.out.printf(ConstantUtils.PRINT_HOLIDAY, month, day, dayOfWeek, worker);
            return;
        }
        System.out.printf(ConstantUtils.PRINT_NORMAL_DAY, month, day, dayOfWeek, worker);
    }
}

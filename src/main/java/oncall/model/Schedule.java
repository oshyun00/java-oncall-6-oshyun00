package oncall.model;

import java.time.DayOfWeek;
import java.util.List;
import oncall.utils.Validator;

public class Schedule {
    String month;
    int day;
    String dayOfWeek;
    boolean isHoliday = false;
    String worker;

    public boolean isHoliday() {
        return isHoliday;
    }

    public void setWorker(String name) {
        this.worker = name;
    }


    public Schedule(String month, int day, String dayOfWeek, boolean isHoliday) {
        this.month = month;
        this.day = day;
        this.dayOfWeek = dayOfWeek;
        this.isHoliday = isHoliday;
    }

    public boolean isWeekEnd() {
        List<String> weekEnd = List.of("토", "일");
        return weekEnd.contains(dayOfWeek);
    }

    public void printSchedule() {
        // 평일이면서 법정공휴일인경우
        if (!isWeekEnd() && isHoliday()) {
            System.out.printf("%s월 %d일 %s(휴일) %s\n", month, day, dayOfWeek, worker);
            return;
        }
        System.out.printf("%s월 %d일 %s %s\n", month, day, dayOfWeek, worker);

    }
}

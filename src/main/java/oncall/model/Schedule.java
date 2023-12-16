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

    public void isHoliday(String month, int day){
        if(Validator.checkHoliday(month, day)){
            isHoliday = true;
        }
    }

    public void setWorker(String name){
        this.worker = name;
    }


    public Schedule(String month, int day, String dayOfWeek, boolean isHoliday) {
        this.month = month;
        this.day = day;
        this.dayOfWeek = dayOfWeek;
        this.isHoliday = isHoliday;
    }

    public boolean isWeekEnd(){
        List<String> weekEnd = List.of("토","일");
        return weekEnd.contains(dayOfWeek);
    }
}

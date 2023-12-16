package oncall.model;

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
}

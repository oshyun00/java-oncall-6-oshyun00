package oncall.model;

import java.util.ArrayList;
import java.util.List;
import oncall.utils.Validator;
import org.w3c.dom.ls.LSOutput;

public class Computer {
    private final List<String> monthAndDayOfWeek;
    private final List<String> WeekdayMember;
    private final List<String> WeekendMember;
    List<Schedule> schedules = new ArrayList<>();
    List<String> dayOfWeekName = List.of("월", "화", "수", "목", "금", "토", "일");

    public Computer(List<String> monthAndDayOfWeek, List<String> WeekdayMember, List<String> weekendMember) {
        this.monthAndDayOfWeek = monthAndDayOfWeek;
        this.WeekdayMember = WeekdayMember;
        this.WeekendMember = weekendMember;
    }

    // 전체 날짜 및 요일 넣기
    public void makeCalender() {
        String month = monthAndDayOfWeek.get(1);

        // 요일 시작 인덱스
        int startIndex = dayOfWeekName.indexOf(month);

        // 총 며칠인지
        int totalDays = Month.getTotalDays(monthAndDayOfWeek.get(0));

        int i = 0;
        int j = startIndex;
        for (i = 0; i < totalDays; i++) {
            boolean isHoliday = Validator.checkHoliday(month, i);
            schedules.add(new Schedule(month, i, dayOfWeekName.get(j++), isHoliday));
            if (j == 7) {
                j -= 7;
            }
        }
        System.out.println("캘린더객체수:" + schedules.size());
    }

//    public void makeCalender()
    // 넣으면서 휴일도 넣어주기

}

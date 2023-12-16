package oncall.model;

import java.util.ArrayList;
import java.util.List;
import oncall.utils.ConstantUtils;

public class Computer {
    private final List<String> monthAndDayOfWeek;
    private final List<String> WeekdayMember;
    private final List<String> WeekendMember;
    List<Schedule> schedules = new ArrayList<>();
    List<String> dayOfWeekName = List.of(ConstantUtils.DAY_OF_WEEK_NAME);

    public Computer(List<String> monthAndDayOfWeek, List<String> WeekdayMember, List<String> weekendMember) {
        this.monthAndDayOfWeek = monthAndDayOfWeek;
        this.WeekdayMember = WeekdayMember;
        this.WeekendMember = weekendMember;
    }

    // 전체 날짜 및 요일 넣기
    public void makeCalender() {
        String month = monthAndDayOfWeek.get(0);

        // 요일 시작 인덱스
        int startIndex = dayOfWeekName.indexOf(monthAndDayOfWeek.get(1));

        // 총 며칠인지
        int totalDays = Month.getTotalDays(monthAndDayOfWeek.get(0));

        int j = startIndex;
        for (int i = 1; i < totalDays + 1; i++) {
            boolean isHoliday = Holiday.isHoliday(month, i);
            schedules.add(new Schedule(month, i, dayOfWeekName.get(j++), isHoliday));
            if (j == ConstantUtils.COUNT_OF_DAY_OF_WEEK) {
                j -= ConstantUtils.COUNT_OF_DAY_OF_WEEK;
            }
        }
    }

    public void makeSchedule() {
        List<Boolean> weekDayUsed = new ArrayList<>();
        List<Boolean> weekEndUsed = new ArrayList<>();
        for (int i = 0; i < WeekdayMember.size(); i++) {
            weekDayUsed.add(false);
            weekEndUsed.add(false);
        }

        List<String> finalMemberList = new ArrayList<>();
        finalMemberList.add("");

        // Schedule순회하면서
        for (int i = 0; i < schedules.size(); i++) {
            Schedule eachSchedule = schedules.get(i);

            if (eachSchedule.isHoliday || eachSchedule.isWeekEnd()) {
                int index = getIndex(weekEndUsed);
                String name = WeekendMember.get(index);

                // 만약 앞사람과 중복된다면 해당 사람 사용 안한걸로 바꾸고 다음사람 가져오기
                if (finalMemberList.get(finalMemberList.size() - 1).equals(name)) {
                    weekEndUsed.set(index, false);
                    index = getIndex(weekEndUsed);
                    name = WeekendMember.get(index);
                }
                finalMemberList.add(name);
                eachSchedule.setWorker(name);
                continue;
            }

            int index = getIndex(weekDayUsed);
            String name = WeekdayMember.get(index);

            // 만약 앞사람과 중복된다면 해당 사람 사용 안한걸로 바꾸고 다음사람 가져오기
            if (finalMemberList.get(finalMemberList.size() - 1).equals(name)) {
                weekDayUsed.set(index, false);
                index = getIndex(weekDayUsed);
                name = WeekdayMember.get(index);
            }
            finalMemberList.add(name);
            eachSchedule.setWorker(name);
        }
    }

    private String checkWeekendDuplicate(List<Boolean> weekEndUsed, List<String> finalMemberList, int index, String name) {
        if (finalMemberList.get(finalMemberList.size() - 1).equals(name)) {
            weekEndUsed.set(index, false);
            index = getIndex(weekEndUsed);
            name = WeekendMember.get(index);
        }
        return name;
    }

    public int getIndex(List<Boolean> isUsed) {
        if (!isUsed.contains(false)) {
            isUsed.replaceAll(ignored -> false);
        }
        int index = isUsed.indexOf(false);
        isUsed.set(index, true);
        return index;
    }

    public List<Schedule> getTotalSchedule() {
        return schedules;
    }

}

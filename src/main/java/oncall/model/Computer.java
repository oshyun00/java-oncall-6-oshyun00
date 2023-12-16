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
        int startIndex = dayOfWeekName.indexOf(monthAndDayOfWeek.get(1));
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

        for (int i = 0; i < schedules.size(); i++) {
            Schedule eachSchedule = schedules.get(i);
            if (eachSchedule.isHoliday() || eachSchedule.isWeekEnd()) {
                choiceMember(weekEndUsed, WeekendMember, finalMemberList, eachSchedule);
                continue;
            }
            choiceMember(weekDayUsed, WeekdayMember, finalMemberList, eachSchedule);
        }
    }

    private void choiceMember(List<Boolean> weekDayUsed, List<String> weekdayMember,
                              List<String> finalMemberList,
                              Schedule eachSchedule) {
        int index = getIndex(weekDayUsed);
        String name = weekdayMember.get(index);
        index = checkDuplicate(weekDayUsed, finalMemberList, index, name);
        name = weekdayMember.get(index);
        finalMemberList.add(name);
        eachSchedule.setWorker(name);
    }

    private static int checkDuplicate(List<Boolean> isUsed, List<String> finalMemberList, int index, String name) {
        if (finalMemberList.get(finalMemberList.size() - 1).equals(name)) {
            isUsed.set(index, false);
            index = index + 1;
            isUsed.set(index, true);
        }
        return index;
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

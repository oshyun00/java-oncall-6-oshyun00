package oncall.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Validator {
    public static void checkBlank(String input) {
        if (input.contains(" ")) {
            throw new IllegalArgumentException("공백은 포함할 수 없습니다.");
        }
    }

    public static void checkMonthAndDayOfWeek(String[] input) {
        List<String> dayOfWeeks = List.of("월", "화", "수", "목", "금", "토", "일");
        if (input.length != 2) {
            throw new IllegalArgumentException("월, 날짜 올바르게 입력");
        }
        try {
            int month = Integer.parseInt(input[0]);
            if (month < 1 || month > 12) {
                throw new IllegalArgumentException("월은 1-12 숫자");
            }
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException("월은 숫자로 입력");
        }
        if (!dayOfWeeks.contains(input[1])) {
            throw new IllegalArgumentException("요일 올바르게 입력");
        }
    }

    public static void checkDuplicateMember(List<String> members) {
        List<String> distinctArr = members.stream().distinct().toList();
        if (members.size() != distinctArr.size()) {
            throw new IllegalArgumentException("중복된 멤버 있음");
        }
    }

    public static void checkMemberNameLength(List<String> members) {
        for (String name : members) {
            if (name.length() > 5) {
                throw new IllegalArgumentException("이름 길이는 5자 이하");
            }
        }
    }

    public static void checkMemberSize(List<String> members) {
        if (members.size() < 5 || members.size() > 35) {
            throw new IllegalArgumentException("비상근무자는 5명~35명");
        }
    }

    public static void checkWeekendMember(List<String> weekdayMember, List<String> weekendMember) {
        // 두개 사이즈 맞는지 검증
        if (weekendMember.size() != weekdayMember.size()) {
            throw new IllegalArgumentException("평일, 주말 사람 수 동일해야함");
        }
        // 동일한 사람 들어있는지 검증
        for (String name : weekdayMember) {
            if (!weekendMember.contains(name)) {
                throw new IllegalArgumentException("평일, 주말 같은 사람 배정되어야함");
            }
        }
    }
}

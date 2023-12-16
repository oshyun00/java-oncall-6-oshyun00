package oncall.utils;

import java.util.List;

public class Validator {
    public static void checkBlank(String input) {
        if (input.contains(" ")) {
            throw new IllegalArgumentException("유효하지 않은 입력 값입니다. 다시 입력해 주세요.");
        }
    }

    public static void checkMonthAndDayOfWeek(String[] input) {
        List<String> dayOfWeeks = List.of("월", "화", "수", "목", "금", "토", "일");
        if (input.length != 2) {
            throw new IllegalArgumentException("유효하지 않은 입력 값입니다. 다시 입력해 주세요.");
        }
        try {
            int month = Integer.parseInt(input[0]);
            if (month < 1 || month > 12) {
                throw new IllegalArgumentException("유효하지 않은 입력 값입니다. 다시 입력해 주세요.");
            }
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException("유효하지 않은 입력 값입니다. 다시 입력해 주세요.");
        }
        if (!dayOfWeeks.contains(input[1])) {
            throw new IllegalArgumentException("유효하지 않은 입력 값입니다. 다시 입력해 주세요.");
        }
    }

    public static void checkDuplicateMember(List<String> members) {
        List<String> distinctArr = members.stream().distinct().toList();
        if (members.size() != distinctArr.size()) {
            throw new IllegalArgumentException("유효하지 않은 입력 값입니다. 다시 입력해 주세요.");
        }
    }

    public static void checkMemberNameLength(List<String> members) {
        for (String name : members) {
            if (name.length() > 5) {
                throw new IllegalArgumentException("유효하지 않은 입력 값입니다. 다시 입력해 주세요.");
            }
        }
    }

    public static void checkMemberSize(List<String> members) {
        if (members.size() < 5 || members.size() > 35) {
            throw new IllegalArgumentException("유효하지 않은 입력 값입니다. 다시 입력해 주세요.");
        }
    }

    public static void checkWeekendMember(List<String> weekdayMember, List<String> weekendMember) {
        // 두개 사이즈 맞는지 검증
        if (weekendMember.size() != weekdayMember.size()) {
            throw new IllegalArgumentException("유효하지 않은 입력 값입니다. 다시 입력해 주세요.");
        }
        // 동일한 사람 들어있는지 검증
        for (String name : weekdayMember) {
            if (!weekendMember.contains(name)) {
                throw new IllegalArgumentException("유효하지 않은 입력 값입니다. 다시 입력해 주세요.");
            }
        }
    }
}

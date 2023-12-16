package oncall.utils;

import java.util.List;

public class Validator {
    public static void checkBlank(String input) {
        if (input.contains(" ")) {
            throw new IllegalArgumentException(ConstantUtils.ERROR_MESSAGE);
        }
    }

    public static void checkMonthAndDayOfWeek(String[] input) {
        List<String> dayOfWeeks = List.of(ConstantUtils.DAY_OF_WEEK_NAME);
        if (input.length != 2) {
            throw new IllegalArgumentException(ConstantUtils.ERROR_MESSAGE);
        }
        checkNumericAndRange(input);
        if (!dayOfWeeks.contains(input[1])) {
            throw new IllegalArgumentException(ConstantUtils.ERROR_MESSAGE);
        }
    }

    private static void checkNumericAndRange(String[] input) {
        try {
            int month = Integer.parseInt(input[0]);
            if (month < ConstantUtils.MIN_MONTH || month > ConstantUtils.MAX_MONTH) {
                throw new IllegalArgumentException(ConstantUtils.ERROR_MESSAGE);
            }
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(ConstantUtils.ERROR_MESSAGE);
        }
    }

    public static void checkDuplicateMember(List<String> members) {
        List<String> distinctArr = members.stream().distinct().toList();
        if (members.size() != distinctArr.size()) {
            throw new IllegalArgumentException(ConstantUtils.ERROR_MESSAGE);
        }
    }

    public static void checkMemberNameLength(List<String> members) {
        for (String name : members) {
            if (name.length() > 5) {
                throw new IllegalArgumentException(ConstantUtils.ERROR_MESSAGE);
            }
        }
    }

    public static void checkMemberSize(List<String> members) {
        if (members.size() < 5 || members.size() > 35) {
            throw new IllegalArgumentException(ConstantUtils.ERROR_MESSAGE);
        }
    }

    public static void checkWeekendMember(List<String> weekdayMember, List<String> weekendMember) {
        if (weekendMember.size() != weekdayMember.size()) {
            throw new IllegalArgumentException(ConstantUtils.ERROR_MESSAGE);
        }
        for (String name : weekdayMember) {
            if (!weekendMember.contains(name)) {
                throw new IllegalArgumentException(ConstantUtils.ERROR_MESSAGE);
            }
        }
    }
}

package oncall.utils;

import java.util.ArrayList;
import java.util.List;

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
}

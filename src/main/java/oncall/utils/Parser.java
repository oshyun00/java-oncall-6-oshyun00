package oncall.utils;

import java.util.List;

public class Parser {
    public static List<String> inputToMonthAndDayOfWeek(String input) {
        Validator.checkBlank(input);
        String[] splitInput = input.split(",");
        Validator.checkMonthAndDayOfWeek(splitInput);

        return List.of(splitInput);
    }
}

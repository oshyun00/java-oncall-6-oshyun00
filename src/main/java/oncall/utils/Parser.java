package oncall.utils;

import java.util.List;

public class Parser {
    public static List<String> inputToMonthAndDayOfWeek(String input) {
        Validator.checkBlank(input);
        String[] splitInput = input.split(",");
        Validator.checkMonthAndDayOfWeek(splitInput);

        return List.of(splitInput);
    }

    public static List<String> inputToMember(String input){
        Validator.checkBlank(input);
        String[] splitInput = input.split(",");
        List<String> member = List.of(splitInput);
        Validator.checkDuplicateMember(member);
        Validator.checkMemberNameLength(member);
        Validator.checkMemberSize(member);
        return List.of(splitInput);
    }
}

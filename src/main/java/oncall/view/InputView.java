package oncall.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import oncall.utils.ConstantUtils;
import oncall.utils.Parser;
import oncall.utils.Validator;

public class InputView {
    public List<String> getMonthAndDayOfWeek() {
        while (true) {
            try {
                System.out.print(ConstantUtils.START_MESSAGE);
                String input = Console.readLine();
                return Parser.inputToMonthAndDayOfWeek(input);
            } catch (IllegalArgumentException exception) {
                System.out.println(ConstantUtils.ERROR_HEADER + exception.getMessage());
            }
        }
    }

    public List<String> getWeekdayMember() {
        List<String> result = new ArrayList<>();
        do {
            try {
                System.out.print(ConstantUtils.GET_WEEKDAY_MESSAGE);
                String input = Console.readLine();
                result = Parser.inputToMember(input);
            } catch (IllegalArgumentException exception) {
                System.out.println(ConstantUtils.ERROR_HEADER + exception.getMessage());
                result = null;
            }
        } while (result == null);
        return result;
    }

    public List<String> getWeekEndMember(List<String> weekdayMember) {
        try {
            System.out.print(ConstantUtils.GET_WEEKEND_MESSAGE);
            String input = Console.readLine();
            List<String> weekendMember = Parser.inputToMember(input);
            Validator.checkWeekendMember(weekdayMember, weekendMember);
            return weekendMember;
        } catch (IllegalArgumentException exception) {
            System.out.println(ConstantUtils.ERROR_HEADER + exception.getMessage());
            return null;
        }
    }
}

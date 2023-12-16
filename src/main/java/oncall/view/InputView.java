package oncall.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import oncall.utils.Parser;

public class InputView {
    public List<String> getMonthAndDayOfWeek() {
        while (true) {
            try {
                System.out.print("비상 근무를 배정할 월과 시작 요일을 입력하세요>");
                String input = Console.readLine();
                return Parser.inputToMonthAndDayOfWeek(input);
            } catch (IllegalArgumentException exception) {
                System.out.println("[ERROR] " + exception.getMessage());
            }
        }
    }

    public List<String> getWeekdayMember() {
        try {
            System.out.print("평일 비상 근무 순번대로 사원 닉네임을 입력하세요>");
            String input = Console.readLine();
            return Parser.inputToMember(input);
        } catch (IllegalArgumentException exception) {
            System.out.println("[ERROR] " + exception.getMessage());
            return null;
        }
    }
}

package oncall.controller;

import java.util.ArrayList;
import java.util.List;
import oncall.model.Computer;
import oncall.view.InputView;

public class OnCallController {

    InputView inputView;

    public OnCallController(InputView inputView) {
        this.inputView = inputView;
    }

    public void start() {

        List<String> monthAndDayOfWeek = inputView.getMonthAndDayOfWeek();

        List<String> weekDayMember = new ArrayList<>();
        List<String> weekEndMember = new ArrayList<>();
        do {
            weekDayMember = inputView.getWeekdayMember();
            weekEndMember = inputView.getWeekEndMember(weekDayMember);
        } while (weekEndMember == null);

        Computer computer = new Computer(monthAndDayOfWeek, weekDayMember, weekEndMember);
        computer.makeCalender();
        computer.makeSchedule();

    }
}

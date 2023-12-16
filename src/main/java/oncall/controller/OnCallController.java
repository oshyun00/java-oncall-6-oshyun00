package oncall.controller;

import java.util.ArrayList;
import java.util.List;
import oncall.model.Computer;
import oncall.model.Schedule;
import oncall.view.InputView;
import oncall.view.OutputView;

public class OnCallController {

    InputView inputView;
    OutputView outputView;

    public OnCallController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
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

        List<Schedule> finalSchedule = computer.getToTalSchedule();
        outputView.printResult(finalSchedule);

    }
}

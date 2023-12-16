package oncall.controller;

import java.util.List;
import oncall.view.InputView;

public class OnCallController {

    InputView inputView;

    public OnCallController(InputView inputView) {
        this.inputView = inputView;
    }

    public void start() {

        List<String> monthAndDayOfWeek;
        do {
            monthAndDayOfWeek = inputView.getMonthAndDayOfWeek();
        }
        while (monthAndDayOfWeek.size() == 0);
    }
}

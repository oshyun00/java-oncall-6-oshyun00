package oncall.view;

import java.util.List;
import oncall.model.Schedule;

public class OutputView {
    public void printResult(List<Schedule> finalSchedule) {
        System.out.println();
        for (Schedule schedule : finalSchedule) {
            schedule.printSchedule();
        }
    }
}

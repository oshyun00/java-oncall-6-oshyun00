package oncall;

import oncall.controller.OnCallController;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        OnCallController onCallController = new OnCallController();

        onCallController.start();
    }
}

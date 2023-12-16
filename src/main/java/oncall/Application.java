package oncall;

import oncall.configurer.AppConfigurer;
import oncall.controller.OnCallController;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        AppConfigurer appConfigurer = new AppConfigurer();
        OnCallController onCallController = new OnCallController(
                appConfigurer.inputView()
        );

        onCallController.start();
    }
}

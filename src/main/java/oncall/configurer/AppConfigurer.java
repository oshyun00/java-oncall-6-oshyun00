package oncall.configurer;

import oncall.view.InputView;
import oncall.view.OutputView;

public class AppConfigurer {
    public InputView inputView() {
        return new InputView();
    }

    public OutputView outputView() {
        return new OutputView();
    }
}

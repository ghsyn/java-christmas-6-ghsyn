package christmas;

import christmas.view.*;

public class Application {
    public static int VISIT_DATE;
    private static String[][] ORDER;

    public static void main(String[] args) {
        OutputView.startMessage();

        VISIT_DATE = InputView.readDate();
        ORDER = InputView.readOrder();

        OutputView.printPreviewMessage(VISIT_DATE);

        Planner planner = new Planner(VISIT_DATE, ORDER);
        planner.createEventPlanner(ORDER);
    }
}

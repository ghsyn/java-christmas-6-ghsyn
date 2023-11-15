package christmas.view;

import camp.nextstep.edu.missionutils.Console;
import christmas.exception.IllegalArgumentExceptionHandler;

public class InputView {
    public static int readDate() {
        int visitDate;

        while (true) {
            System.out.println("12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)");
            String input = Console.readLine();
            try {
                visitDate = Integer.parseInt(input);
                break;
            } catch (NumberFormatException e) {
                new IllegalArgumentExceptionHandler("유효하지 않은 날짜입니다. 다시 입력해 주세요.");
            }
        }

        return visitDate;
    }

    public static String[][] readOrder() {
        String[][] order = null;

        while (order == null) {
            System.out.println("주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)");
            String input = Console.readLine();

            try {
                String[] menu = input.split(",");
                order = new String[menu.length][2];

                for (int i = 0; i < menu.length; i++) {
                    String[] menuInfo = menu[i].trim().split("-");
                    if (menuInfo.length == 2) {
                        order[i][0] = menuInfo[0].trim();
                        order[i][1] = menuInfo[1].trim();
                    } else {
                        throw new IllegalArgumentException("유효하지 않은 주문입니다. 다시 입력해 주세요.");
                    }

                }
            } catch (IllegalArgumentException e) {
                new IllegalArgumentExceptionHandler(e.getMessage());
            }
        }

        return order;
    }
}
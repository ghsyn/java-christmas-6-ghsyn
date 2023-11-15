package christmas.view;

import camp.nextstep.edu.missionutils.Console;
import christmas.domain.menu.Drink;
import christmas.domain.menu.Menu;
import christmas.exception.IllegalArgumentExceptionHandler;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class InputView {
    public static int readDate() {
        int visitDate;

        while (true) {
            System.out.println("12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)");
            String input = Console.readLine();
            try {
                visitDate = Integer.parseInt(input);
                if (1 > visitDate || visitDate > 31) {
                    throw new IllegalArgumentException("유효하지 않은 날짜입니다. 다시 입력해 주세요.");
                }
                return visitDate;
            } catch (NumberFormatException e) {
                new IllegalArgumentExceptionHandler("유효하지 않은 날짜입니다. 다시 입력해 주세요.");
            } catch (IllegalArgumentException e) {
                new IllegalArgumentExceptionHandler(e.getMessage());
            }
        }
    }

    // 형식에 맞는지
    // 정수인지
    // 음료만 주문하는지
    public static String[][] readOrder() {
        String[][] order = null;

        while (order == null) {
            System.out.println("주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)");
            String input = Console.readLine();

            try {
                order = checkOrderFormat(input);

                if (order == null) {
                    throw new IllegalArgumentException("유효하지 않은 주문입니다. 다시 입력해 주세요.");
                }

                for (String[] menu : order) {
                    String korName = menu[0];
                    if (!(isValidMenu(korName))) {
                        order = null;
                        throw new IllegalArgumentException(korName + "은(는) 없는 메뉴 입니다.");
                    }
                }

                if (countMenu(order) == 0) {
                    order = null;
                    throw new IllegalArgumentException("메뉴의 개수는 1 이상의 정수여야 합니다.");
                }
                if (countMenu(order) > 20) {
                    order = null;
                    throw new IllegalArgumentException("메뉴는 한 번에 최대 20개까지 가능합니다.");
                }

                if (isAllDrink(order)) {
                    order = null;
                    throw new IllegalArgumentException("음료만 주문할 수는 없습니다.");
                }
            } catch (IllegalArgumentException e) {
                new IllegalArgumentExceptionHandler(e.getMessage());
            }
        }
        return order;
    }

    private static String[][] checkOrderFormat(String input) {
        String[] menu = input.split(",");
        String[][] order = new String[menu.length][2];

        for (int i = 0; i < menu.length; i++) {
            String[] menuInfo = menu[i].trim().split("-");
            if (menuInfo.length == 2) {
                order[i][0] = menuInfo[0].trim();
                order[i][1] = menuInfo[1].trim();
            }
            else {
                return null;
            }
        }
        return order;
    }

    private static boolean isValidMenu(String korName) {
        Set<String> menuSet = Arrays.stream(Menu.getAllItems())
                .map(Menu::getKorName)
                .collect(Collectors.toSet());

        return menuSet.contains(korName);
    }

    private static int countMenu(String[][] order) {
        int sum = 0;
        try {
            for (String[] menu : order) {
                sum += Integer.parseInt(menu[1]);
            }
            return sum;
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    private static boolean isAllDrink(String[][] order) {
        int drinkCount = 0;

        for (String[] menu : order) {
            String korName = menu[0];
            for (Menu menuEnum : Menu.getAllItems()) {
                drinkCount += checkMenuTypeIsDrink(korName, menuEnum);
            }
        }
        if (drinkCount == order.length) {
            return true;
        }
        return false;
    }

    private static int checkMenuTypeIsDrink(String menuName, Menu menu) {
        if (menu.getKorName().equals(menuName)) {
            if (menu instanceof Drink) {
                return 1;
            }
        }
        return 0;
    }
}
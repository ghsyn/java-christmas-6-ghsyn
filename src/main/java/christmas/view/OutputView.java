package christmas.view;

import christmas.badge.BadgeGrant;
import christmas.discount.Discount;
import christmas.giveaway.Giveaway;

import java.text.DecimalFormat;

public class OutputView {
    private static final DecimalFormat decimalFormat = new DecimalFormat("###,###");

    public static void startMessage() {
        System.out.println("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.");
    }

    public static void printPreviewMessage(int visitDate) {
        System.out.println("12월 " + visitDate + "일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!");
    }

    public static void printOrder(String[][] order) {
        System.out.println("\n<주문 메뉴>");
        for (String[] menu : order) {
            String korName = menu[0];
            String num = menu[1];

            System.out.println(korName + " " + num + "개");
        }
    }

    public static void printOriginalPrice(int originalPrice) {
        System.out.println("\n<할인 전 총주문 금액>");
        System.out.println(decimalFormat.format(originalPrice) + "원");
    }

    public static void printGiveawayMessage() {
        System.out.println("\n<증정 메뉴>");
    }

    public static void printGiveaway(Giveaway giveawayEvent) {
        System.out.println(giveawayEvent.getMenuKorName() + " " + giveawayEvent.getNumberOfMenu() + "개");
    }

    public static void printBenefitListMessage() {
        System.out.println("\n<혜택 내역>");
    }

    public static void printDiscountBenefitList(Discount discountEvent) {
        if (discountEvent.getSalePrice() == 0) {
            return;
        }
        System.out.println(discountEvent.getEventName() + ": " + decimalFormat.format(discountEvent.getSalePrice()) + "원");
    }

    public static void printGiveawayBenefitList(Giveaway giveawayEvent) {
        System.out.println(giveawayEvent.getEventName() + ": " + decimalFormat.format(giveawayEvent.getMenuPrice()) + "원");
    }

    public static void printTotalBenefitPrice(int totalBenefitPrice) {
        System.out.println("\n<총혜택 금액>");
        System.out.println(decimalFormat.format(totalBenefitPrice) + "원");
    }

    public static void printBadge(BadgeGrant badgeEvent) {
        System.out.println("\n<" + badgeEvent.getEventName() + ">");
        if (!badgeEvent.getBadge().isEmpty()) {
            System.out.println(badgeEvent.getBadge());
        } else if (badgeEvent.getBadge().isEmpty()) {
            nothingMessage();
        }
    }

    public static void nothingMessage() {
        System.out.println("없음");
    }

    public static void printPayPrice(int payPrice) {
        System.out.println("\n<할인 후 예상 결제 금액>");
        System.out.println(decimalFormat.format(payPrice) + "원");
    }
}
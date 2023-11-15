package christmas.controller;

import christmas.discount.*;

import java.util.List;

import static christmas.Application.VISIT_DATE;

public class DiscountValidator {
    private static final List<String> WEEKDAY = List.of("일", "월", "화", "수", "목");
    private static final List<String> WEEKEND = List.of("금", "토");
    private static final List<String> SPECIAL_DAY = List.of("일");

    public static void doDiscount(Discount discountEvent, String visitDay, String[][] order) {
        if (discountEvent instanceof ChristmasEvent) {
            if (1 <= VISIT_DATE && VISIT_DATE <= 25) {
                discountEvent.doSale(VISIT_DATE);
            }
        }
        if (discountEvent instanceof WeekdayEvent) {
            if (WEEKDAY.contains(visitDay)) {
                discountEvent.doSale(order);
            }
        }
        if (discountEvent instanceof WeekendEvent) {
            if (WEEKEND.contains(visitDay)) {
                discountEvent.doSale(order);
            }
        }
        if (discountEvent instanceof SpecialEvent) {
            if (SPECIAL_DAY.contains(visitDay) || VISIT_DATE == 25) {
                discountEvent.doSale();
            }
        }
    }
}

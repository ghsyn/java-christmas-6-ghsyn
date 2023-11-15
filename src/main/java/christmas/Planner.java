package christmas;

import christmas.badge.*;
import christmas.controller.*;
import christmas.discount.*;
import christmas.domain.*;
import christmas.domain.menu.*;
import christmas.exception.IllegalArgumentExceptionHandler;
import christmas.giveaway.*;
import christmas.view.*;

import java.util.List;

public class Planner {
    private final List<Discount> discountEvents = List.of(new ChristmasEvent(), new WeekdayEvent(), new WeekendEvent(), new SpecialEvent());
    private final List<Giveaway> giveawayEvents = List.of(new ChampagneEvent());
    private final List<BadgeGrant> badgeGrantEvents = List.of(new DecemberEvent());
    private int originalPrice;
    private final String visitDay;
    private int salePrice;
    private int giftPrice;

    public Planner(int visitDate, String[][] order) {
        this.visitDay = Calendar.findDayOfWeek(visitDate);
        this.originalPrice = getOriginalPrice(order);
        salePrice = 0;
        giftPrice = 0;
    }

    private int getOriginalPrice(String[][] order) {
        for (String[] item : order) {
            String korName = item[0];
            String quantity = item[1];

            originalPrice += getItemPrice(korName, quantity);
        }
        return originalPrice;
    }

    private int getItemPrice(String korName, String quantity) {
        try {
            for (Menu menu : Menu.getAllItems()) {
                if (menu.getKorName().equals(korName)) {
                    return menu.getPrice() * Integer.parseInt(quantity);
                }
            }
            throw new IllegalArgumentException(korName + "은(는) 없는 메뉴입니다.");
        } catch (NumberFormatException e) {
            new IllegalArgumentExceptionHandler("유효하지 않은 주문입니다. 다시 입력해 주세요.");
        } catch (IllegalArgumentException e) {
            new IllegalArgumentExceptionHandler(e.getMessage());
        }
        return 0;
    }

    private void applyEvents(String[][] order) {
        if (originalPrice < 10000) {
            return;
        }
        for (Discount discountEvent : discountEvents) {
            DiscountValidator.doDiscount(discountEvent, visitDay, order);
            salePrice += discountEvent.getSalePrice();
        }
        for (Giveaway giveawayEvent : giveawayEvents) {
            GiveawayValidator.comparePrice(giveawayEvent, originalPrice);
            if (giveawayEvent.getIsApplied()) {
                giftPrice += giveawayEvent.getMenuPrice();
            }
        }
        for (BadgeGrant badgeGrantEvent : badgeGrantEvents) {
            BadgeGrantValidator.comparePrice(badgeGrantEvent, salePrice + giftPrice);
        }
    }

    public void createEventPlanner(String[][] order) {
        OutputView.printOrder(order);
        OutputView.printOriginalPrice(originalPrice);

        applyEvents(order);

        OutputView.printGiveawayMessage();
        if (giftPrice != 0) {
            giveawayEvents.forEach(OutputView::printGiveaway);
        } else {
            OutputView.nothingMessage();
        }

        OutputView.printBenefitListMessage();
        if ((salePrice + giftPrice) != 0) {
            discountEvents.forEach(OutputView::printDiscountBenefitList);
            giveawayEvents.forEach(OutputView::printGiveawayBenefitList);
        } else {
            OutputView.nothingMessage();
        }

        OutputView.printTotalBenefitPrice(salePrice + giftPrice);
        OutputView.printPayPrice(originalPrice + salePrice);
        for (BadgeGrant badgeGrantEvent : badgeGrantEvents) {
            OutputView.printBadge(badgeGrantEvent);
        }
    }
}
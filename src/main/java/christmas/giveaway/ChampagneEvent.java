package christmas.giveaway;

import christmas.domain.Drink;

public class ChampagneEvent implements Giveaway {
    private static final String EVENT_NAME = "";
    private static final int MINIMUM_ORIGINAL_PRICE = 120000;
    private static final String GIFT_KOR_NAME = Drink.CHAMPAGNE.getKorName();
    private static final int GIFT_PRICE = Drink.CHAMPAGNE.getPrice();
    private static final int GIFT_NUM = 1;

    @Override
    public boolean isGiveaway(int originalPrice) {
        if (originalPrice > MINIMUM_ORIGINAL_PRICE) {
            return true;
        }
        return false;
    }

    @Override
    public String getEventName() {
        return EVENT_NAME + "증정 이벤트";
    }

    @Override
    public String getMenuKorName() {
        return GIFT_KOR_NAME;
    }

    @Override
    public int getMenuPrice() {
        return GIFT_PRICE;
    }

    @Override
    public int getNumberOfMenu() {
        return GIFT_NUM;
    }
}
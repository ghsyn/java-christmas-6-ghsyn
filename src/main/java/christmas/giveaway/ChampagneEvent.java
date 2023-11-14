package christmas.giveaway;

import christmas.domain.menu.Drink;

public class ChampagneEvent implements Giveaway {
    private static final String EVENT_NAME = "";
    private static boolean isApplied = false;
    private static final String GIFT_KOR_NAME = Drink.CHAMPAGNE.getKorName();
    private static final int GIFT_PRICE = Drink.CHAMPAGNE.getPrice();
    private static final int GIFT_NUM = 1;

    @Override
    public void doGiveaway(int originalPrice) {
        isApplied = true;
    }

    @Override
    public boolean getIsApplied() {
        return isApplied;
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
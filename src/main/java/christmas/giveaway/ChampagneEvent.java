package christmas.giveaway;

import christmas.OutputView;
import christmas.menu.Drink;

public class ChampagneEvent implements Giveaway {
    private static final int MINIMUM_ORIGINAL_PRICE = 120000;
    private static final String GIFT_KOR_NAME = Drink.CHAMPAGNE.getKorName();
    private static final int GIFT_NUM = 1;

    @Override
    public boolean doGiveaway(int originalPrice) {
        if (originalPrice > MINIMUM_ORIGINAL_PRICE) {
            OutputView.giveawayMessage(getMenuKorName(), getNumberOfMenu());
            return true;
        }
        return false;
    }

    @Override
    public String getMenuKorName() {
        return GIFT_KOR_NAME;
    }

    @Override
    public int getNumberOfMenu() {
        return GIFT_NUM;
    }
}
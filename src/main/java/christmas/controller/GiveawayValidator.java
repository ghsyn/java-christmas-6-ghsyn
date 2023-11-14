package christmas.controller;

import christmas.giveaway.*;

public class GiveawayValidator {
    private static final int CHAMPAGNE_EVENT_MINIMUM_ORIGINAL_PRICE = 120000;
    public static void comparePrice(Giveaway giveawayEvent, int originalPrice) {
        if (originalPrice > CHAMPAGNE_EVENT_MINIMUM_ORIGINAL_PRICE) {
            giveawayEvent.doGiveaway(originalPrice);
        }
    }
}

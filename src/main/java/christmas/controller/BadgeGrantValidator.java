package christmas.controller;

import christmas.badge.BadgeGrant;

public class BadgeGrantValidator {
    public static void comparePrice(BadgeGrant badgeGrantEvent, int benefitPrice) {
        badgeGrantEvent.doGrant(benefitPrice);
    }
}

package christmas.badge;

import java.util.Map;
import java.util.TreeMap;

public class DecemberEvent implements BadgeGrant {
    private static final Map<Integer, String> BADGES = new TreeMap<>();
    static {
        BADGES.put(5000, "별");
        BADGES.put(10000, "트리");
        BADGES.put(20000, "산타");
    }
    private static String badge = "";

    @Override
    public boolean doGrant(int totalSalePrice, int totalGiftPrice) {
        int benefitPrice = totalSalePrice + totalGiftPrice;

        for (Map.Entry<Integer, String> pair : BADGES.entrySet()) {
            if (benefitPrice >= pair.getKey()) {
                badge = pair.getValue();
            }
        }

        return !badge.isEmpty();
    }

    @Override
    public String getBadge() {
        return badge;
    }
}

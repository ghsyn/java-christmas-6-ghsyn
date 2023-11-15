package christmas.badge;

import java.util.Map;
import java.util.TreeMap;

public class DecemberEvent implements BadgeGrant {
    private final String EVENT_NAME = "12월 이벤트 배지";
    private static final Map<Integer, String> BADGES = new TreeMap<>();
    static {
        BADGES.put(5000, "별");
        BADGES.put(10000, "트리");
        BADGES.put(20000, "산타");
    }
    private static String badge = "";

    @Override
    public void doGrant(int benefitPrice) {
        for (Map.Entry<Integer, String> pair : BADGES.entrySet()) {
            if (-(benefitPrice) >= pair.getKey()) {
                badge = pair.getValue();
            }
        }
    }

    @Override
    public String getEventName() {
        return EVENT_NAME;
    }

    @Override
    public String getBadge() {
        return badge;
    }
}

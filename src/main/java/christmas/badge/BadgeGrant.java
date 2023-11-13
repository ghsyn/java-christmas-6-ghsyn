package christmas.badge;

public interface BadgeGrant {
    boolean doGrant(int totalSalePrice, int totalGiftPrice);
    String getEventName();
    String getBadge();
}

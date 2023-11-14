package christmas.badge;

public interface BadgeGrant {
    void doGrant(int totalSalePrice, int totalGiftPrice);
    String getEventName();
    String getBadge();
}

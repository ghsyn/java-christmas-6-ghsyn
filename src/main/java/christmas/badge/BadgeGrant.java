package christmas.badge;

public interface BadgeGrant {
    void doGrant(int benefitPrice);
    String getEventName();
    String getBadge();
}

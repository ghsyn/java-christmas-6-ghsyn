package christmas.giveaway;

public interface Giveaway {

    void doGiveaway(int originalPrice);

    boolean getIsApplied();

    String getEventName();

    String getMenuKorName();

    int getMenuPrice();

    int getNumberOfMenu();
}

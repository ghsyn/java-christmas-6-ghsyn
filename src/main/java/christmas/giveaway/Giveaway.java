package christmas.giveaway;

public interface Giveaway {

    boolean isGiveaway(int originalPrice);
    String getEventName();
    String getMenuKorName();
    int getMenuPrice();
    int getNumberOfMenu();
}

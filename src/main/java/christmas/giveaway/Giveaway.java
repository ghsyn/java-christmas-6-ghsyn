package christmas.giveaway;

public interface Giveaway {

    boolean doGiveaway(int originalPrice);
    String getEventName();
    String getMenuKorName();
    int getMenuPrice();
    int getNumberOfMenu();
}

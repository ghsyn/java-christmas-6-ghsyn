package christmas.discount;

public interface Discount {

    void doSale(int visitDate);
    void doSale(String[][] eventMenuArray);
    String getEventName();
    int getSalePrice();
}

package christmas.discount;

public interface Discount {

    void doSale(int visitDate);
    void doSale(String[][] eventMenuArray);
    int getSalePrice();
}

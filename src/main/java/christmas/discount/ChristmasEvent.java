package christmas.discount;

public class ChristmasEvent implements Discount {
    private final String EVENT_NAME = "크리스마스 디데이 할인";
    private int salePrice;
    private static final int START_SALE_AMOUNT = 1000;
    private static final int INCREASE_SALE_AMOUNT = 100;

    @Override
    public void doSale(int visitDate) {
        salePrice = START_SALE_AMOUNT - (visitDate - 1) * INCREASE_SALE_AMOUNT;
    }

    @Override
    public void doSale(String[][] eventMenuArray) {
    }

    @Override
    public String getEventName() {
        return EVENT_NAME;
    }

    @Override
    public int getSalePrice() {
        return salePrice;
    }
}

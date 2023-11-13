package christmas.discount;

public class SpecialEvent implements Discount {
    private final String EVENT_NAME = "특별 할인";
    private static final int SPECIAL_SALE_AMOUNT = 1000;

    @Override
    public void doSale(int visitDate) {
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
        return SPECIAL_SALE_AMOUNT;
    }
}

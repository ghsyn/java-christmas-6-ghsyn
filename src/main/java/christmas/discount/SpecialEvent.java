package christmas.discount;

public class SpecialEvent implements Discount {
    private static final int SPECIAL_SALE_AMOUNT = 1000;

    @Override
    public void doSale(int visitDate) {
    }

    @Override
    public void doSale(String[][] eventMenuArray) {
    }

    @Override
    public int getSalePrice() {
        return SPECIAL_SALE_AMOUNT;
    }
}

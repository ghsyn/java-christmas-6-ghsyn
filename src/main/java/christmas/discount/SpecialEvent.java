package christmas.discount;

public class SpecialEvent implements Discount {
    private static final int SPECIAL_SALE_AMOUNT = 1000;

    @Override
    public int doSale(int originalPrice) {
        return originalPrice - SPECIAL_SALE_AMOUNT;
    }
}

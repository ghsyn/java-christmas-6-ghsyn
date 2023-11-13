package christmas.discount;

abstract class SpecialEvent implements Discount {
    private static final int SPECIAL_SALE_AMOUNT = 1000;

    @Override
    public int getSalePrice() {
        return SPECIAL_SALE_AMOUNT;
    }
}

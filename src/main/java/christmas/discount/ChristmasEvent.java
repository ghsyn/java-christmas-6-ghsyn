package christmas.discount;

abstract class ChristmasEvent implements Discount {
    private int salePrice;
    private static final int START_SALE_AMOUNT = 1000;
    private static final int INCREASE_SALE_AMOUNT = 100;

    @Override
    public void doSale(int visitDate) {
        salePrice = START_SALE_AMOUNT - (visitDate - 1) * INCREASE_SALE_AMOUNT;
    }

    @Override
    public int getSalePrice() {
        return salePrice;
    }
}

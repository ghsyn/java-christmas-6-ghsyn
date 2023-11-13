package christmas.discount;

abstract class WeekendEvent implements Discount {
    private int salePrice;
    private static final int MAIN_SALE_AMOUNT = 2023;

    @Override
    public void doSale(String[][] mainMenuArray) {
        int numberOfMain = 0;
        try {
            for (String count : mainMenuArray[0]) {
                numberOfMain += Integer.parseInt(count);
            }
        } catch (NumberFormatException e) {
            // TODO: IllegalArgumentException 처리
            throw new IllegalArgumentException();
        }

        salePrice = MAIN_SALE_AMOUNT * numberOfMain;
    }

    @Override
    public int getSalePrice() {
        return salePrice;
    }
}

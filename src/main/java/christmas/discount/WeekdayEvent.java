package christmas.discount;

public class WeekdayEvent implements Discount {
    private int salePrice;
    private static final int DESSERT_SALE_AMOUNT = 2023;

    public void setSalePrice(String[][] dessertMenuArray) {
        int numberOfDessert = 0;
        try {
            for (String count : dessertMenuArray[0]) {
                numberOfDessert += Integer.parseInt(count);
            }
        } catch (NumberFormatException e) {
            // TODO: IllegalArgumentException 처리
            throw new IllegalArgumentException();
        }

        salePrice = DESSERT_SALE_AMOUNT * numberOfDessert;
    }

    @Override
    public int doSale(int originalPrice) {
        return originalPrice - salePrice;
    }
}

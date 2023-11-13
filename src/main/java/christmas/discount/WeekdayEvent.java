package christmas.discount;

public class WeekdayEvent implements Discount {
    private final String EVENT_NAME = "평일 할인";
    private int salePrice;
    private static final int DESSERT_SALE_AMOUNT = 2023;

    @Override
    public void doSale(int visitDate) {
    }

    @Override
    public void doSale(String[][] dessertMenuArray) {
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
    public String getEventName() {
        return EVENT_NAME;
    }

    @Override
    public int getSalePrice() {
        return salePrice;
    }
}

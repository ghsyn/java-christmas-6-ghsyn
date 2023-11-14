package christmas.discount;

public class WeekendEvent implements Discount {
    private final String EVENT_NAME = "주말 할인";
    private int salePrice;
    private static final int MAIN_SALE_AMOUNT = 2023;

    @Override
    public void doSale() {
    }

    @Override
    public void doSale(int visitDate) {
    }

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
    public String getEventName() {
        return EVENT_NAME;
    }

    @Override
    public int getSalePrice() {
        return salePrice;
    }
}

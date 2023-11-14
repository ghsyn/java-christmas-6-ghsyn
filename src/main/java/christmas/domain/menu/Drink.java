package christmas.domain.menu;

public enum Drink implements Menu {

    ZERO_COKE("제로콜라", 3000),
    RED_WINE("레드와인", 60000),
    CHAMPAGNE("샴페인", 25000);

    private String korName;
    private int price;

    Drink(String korName, int price) {
        this.korName = korName;
        this.price = price;
    }

    @Override
    public String getKorName() {
        return korName;
    }

    @Override
    public int getPrice() {
        return price;
    }
}

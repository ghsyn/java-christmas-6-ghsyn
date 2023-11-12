package christmas.menu;

public enum Drink {

    ZERO_COKE("제로콜라", 3000, 0),
    RED_WINE("레드와인", 60000, 0),
    CHAMPAGNE("샴페인", 25000, 0);

    private String korName;
    private int price;
    private int count;

    Drink(String korName, int price, int count) {
        this.korName = korName;
        this.price = price;
        this.count = count;
    }

    public String getKorName() {
        return korName;
    }

    public int getPrice() {
        return price;
    }
    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count += count;
    }
}

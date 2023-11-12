package christmas.menu;

public enum Dessert {
    CHOCOLATE_CAKE("초코케이크", 15000, 0),
    ICE_CREAM("아이스크림", 5000, 0);
    private String korName;
    private int price;
    private int count;

    Dessert(String korName, int price, int count) {
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

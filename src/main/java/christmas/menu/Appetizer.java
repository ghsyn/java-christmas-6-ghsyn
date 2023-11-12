package christmas.menu;

public enum Appetizer {
    BUTTON_MUSHROOM_SOUP("양송이수프", 6000 ,0),
    TAPAS("타파스", 5500, 0),
    CAESAR_SALAD("시저샐러드", 8000, 0);

    private String korName;
    private int price;
    private int count;

    Appetizer(String korName, int price, int count) {
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
        this.count = count;
    }
}

package christmas.domain.menu;

public enum Appetizer implements Menu {
    BUTTON_MUSHROOM_SOUP("양송이수프", 6000),
    TAPAS("타파스", 5500),
    CAESAR_SALAD("시저샐러드", 8000);

    private String korName;
    private int price;

    Appetizer(String korName, int price) {
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

package christmas.domain.menu;

public enum Dessert implements Menu {
    CHOCOLATE_CAKE("초코케이크", 15000),
    ICE_CREAM("아이스크림", 5000);
    private String korName;
    private int price;

    Dessert(String korName, int price) {
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

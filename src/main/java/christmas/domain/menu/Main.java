package christmas.domain.menu;

public enum Main implements Menu {
    T_BONE_STEAK("티본스테이크", 55000),
    BARBECUE_RIBS("바비큐립", 54000),
    SEAFOOD_PASTA("해산물파스타", 35000),
    CHRISTMAS_PASTA("크리스마스파스타", 25000);

    private String korName;
    private int price;

    Main(String korName, int price) {
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

package christmas.menu;

public enum Main {
    T_BONE_STEAK("티본스테이크", 55000, 0),
    BARBECUE_RIBS("바비큐립", 54000, 0),
    SEAFOOD_PASTA("해산물파스타", 35000, 0),
    CHRISTMAS_PASTA("크리스마스파스타", 25000, 0);

    private String korName;
    private int price;
    private int count;

    Main(String korName, int price, int count) {
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

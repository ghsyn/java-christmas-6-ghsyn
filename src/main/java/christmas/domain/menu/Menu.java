package christmas.domain.menu;

import java.util.Arrays;
import java.util.stream.Stream;

public interface Menu {
    String getKorName();
    int getPrice();

    static Menu[] getAllItems() {
        return Stream.of(Appetizer.values(), Main.values(), Dessert.values(), Drink.values())
                .flatMap(Arrays::stream)
                .toArray(Menu[]::new);
    }
}

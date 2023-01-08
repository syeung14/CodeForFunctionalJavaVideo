package shopping2;

import java.util.ArrayList;
import java.util.List;

public class StockControl {
    public static void main(String[] args) {
        List<Pair<Shoe>> lps = new ArrayList<>();
        lps.add(new Pair(new Shoe(44, "Red"), new Shoe(44, "Red")));
    }
}

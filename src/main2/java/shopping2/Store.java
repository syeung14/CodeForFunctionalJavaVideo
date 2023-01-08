package shopping2;

public class Store {

    public static void main(String[] args) {
//        Pair<String> p = new Pair<>("fred", "Jones");
//        Object right = p.getRight();
//        System.out.println(p.getLeft());

        ClothingPair<Shoe> ps = new ClothingPair<>(new Shoe(45, "Brown"), new Shoe(45, "Brown"));

        System.out.println("Match:"  + ps.isMatched());
    }
}

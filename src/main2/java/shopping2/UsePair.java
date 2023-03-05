package shopping2;

public class UsePair {

    public static void main(String[] args) {
        Pair<Shoe> p = new Pair<>(new Shoe(2, ""), new Shoe(9, ""));

        System.out.println(p.getLeft());
    }

}

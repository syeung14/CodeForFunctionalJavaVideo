package shopping;

public class Shop {
  public static void main(String[] args) {
    ClothingPair<Sock> ps = new ClothingPair<>(new Sock(9, "Red"), new Sock(10, "Red"));
    System.out.println("I bought this: " + ps);
    System.out.println("matches? " + ps.isMatched());

    Sock s1 = new Sock(9, "Brown");
    Sock s2 = new Sock(10, "Red");
//    boolean theyMatch = ClothingPair.match(s1, s2);
    boolean theyMatch = ClothingPair.<Sock>match(s1, s2);
    System.out.println(theyMatch);
  }
}

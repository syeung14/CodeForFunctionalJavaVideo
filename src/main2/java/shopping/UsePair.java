package shopping;

import java.time.LocalDate;

public class UsePair {
  public static void main(String[] args) {
//    Pair<String> p = new Pair<>("hello", LocalDate.now());
    Pair<String> p = new Pair<>("hello", "bonjour");

    p.setLeft("Banana");
//    p.setRight(LocalDate.now());
    String r = p.getRight();

    Pair<LocalDate> pld = new Pair<>(LocalDate.now(), LocalDate.now());

    var apair = new Pair<>("hello", LocalDate.now());
   }
}

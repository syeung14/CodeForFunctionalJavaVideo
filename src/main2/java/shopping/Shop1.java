package shopping;

import java.time.LocalDate;

public class Shop1 {
  public static void main(String[] args) {
    // String is not "Colored" so cannot be used in ClothingPair, once
    // E extends Colored
//    ClothingPair<String> pString = new ClothingPair<>("Hello", "Bonjour");
    Pair<String> pString = new Pair<>("Hello", "Bonjour");
    ClothingPair<Glove> gloves = new ClothingPair<>(new Glove("Red", 12), new Glove("Red", 12));
//    gloves.setRight(new Shoe("Red", 44));

    ClothingPair<Shoe> shoes = new ClothingPair<>(new Shoe("Red", 44), new Shoe("Brown", 44));
//    shoes.setRight(new Glove("Brown", 12));
    Shoe sh = shoes.getLeft();

//    System.out.println("Gloves match? " + gloves.matches());

    System.out.println("Match? " +
        ClothingPair.match(new Glove("Red", 12), new Glove("Brown", 12)));

    // IF type inferencing fails for method invocation (e.g. static method
    // that takes zero arguments!?) then can make explicit assignment to
    // generic type variable using this syntax...
//    System.out.println("Match? " +
//        ClothingPair.<Glove>match(new Glove("Red", 12), new Glove("Brown", 12)));
   }
}

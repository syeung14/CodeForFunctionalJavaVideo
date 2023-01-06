package shopping;
// base class comes first, interfaces after...
// MyClass extends ParentClass implements IfOne, IfTwo

public class ClothingPair<E extends /*Object & */Sized & Colored/*, String*/> extends Pair<E> {
//  String thingy = "Hello";
//  java.lang.String thingy = "Hello";

  public ClothingPair(E left, E right) {
    super(left, right);
  }

  public boolean isMatched() {
//    E theLeft = left;
//    Sized & Colored theLeft = left;
    var theLeft = left;
    return left.getSize() == right.getSize()
        && left.getColor().equals(right.getColor());
  }

  public <F extends Sized> boolean matches(F f) {
    return f.getSize() == left.getSize();
  }

//  public <F extends Sized> boolean sizeMatches(F f) {
//    return f.getSize() == left.getSize();
//  }

  public static <E extends Sized & Colored> boolean match(E left, E right) {
    return left.getSize() == right.getSize()
        && left.getColor().equals(right.getColor());
  }
}

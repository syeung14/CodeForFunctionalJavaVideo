package shopping;

import java.util.List;
import java.util.function.BiPredicate;

// generic parameter "declaration"
public class Pair<E> {
  protected E left;
  protected E right;

  public Pair(E left, E right) {
    this.left = left;
    this.right = right;
  }

  public List<E> getBoth() {
    return List.of(left, right);
  }
  public E getLeft() {
    return left;
  }

  // Strategy
  BiPredicate<E, E> matcher;
  // OK but let the caller do it themseves???
  // this argument is 'command' pattern
  public boolean matchedBy(BiPredicate<E, E> test) {
//    return test.test(left, right);
    return matcher.test(left, right);
  }

//  public boolean isMatched() {
//    // maybe use instanceof??? NO makes this class dependent on Sock
//
//
//    return left.getSize() == right.getSize();
//  }

  public void setLeft(E left) {
    this.left = left;
  }

  public E getRight() {
    return right;
  }

  public void setRight(E right) {
    this.right = right;
  }

  @Override
  public String toString() {
    return "Pair{" +
        "left=" + left +
        ", right=" + right +
        '}';
  }

  //  // probably preferred.
//  public boolean equvalent(Pair<E> other) {return false;}
//  @Override
//  public boolean equals(Object other) {
////    if (other instanceof Pair theOther) {
//    if (other instanceof Pair) {
//      Pair theOther = (Pair)other;
//      Object oLeft = theOther.left;
//      Object oRight = theOther.right;
//      Class lType = left.getClass();
//      Class rType = right.getClass();
//      // check compatability of types...
//      // TONS OF reflection :)
//      // or delegate to above "equivalent" method (using casts)
//
//    }
//  }
}

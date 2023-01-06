package wildcard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

interface Criterion<E> {
  boolean test(E e);
}

class LongText implements Criterion<CharSequence> {
  @Override
  public boolean test(CharSequence s) {
    return s.length() > 3;
  }
}

class FirstThree implements Function<CharSequence, CharSequence> {

  @Override
  public CharSequence apply(CharSequence s) {
    return s.subSequence(0, 3);
  }
}

// class LongString implements Criterion<String> {
//  @Override
//  public boolean test(String s) {
//    return s.length() > 3;
//  }
//}
//
//class LongStringBuilder implements Criterion<StringBuilder> {
//  @Override
//  public boolean test(StringBuilder s) {
//    return s.length() > 3;
//  }
//}

public class Illustrate {
  public static <E> List<E> getMatchingStrings(
      List<E> ls, Criterion<? super E> cs)
  {
    List<E> out = new ArrayList<>();
    for (E s : ls) {
      if (cs.test(s)) {
        out.add(s);
      }
    }
    return out;
  }

  public static <E, F> List<F> map(
      List<E> input, Function<? super E, ? extends F> op) {
    List<F> out = new ArrayList<>();
    for (E s : input) {
      out.add(op.apply(s));
    }
    return out;
  }

  public static <E> void showAll(List<E> ls) {
    for (E s : ls) {
      System.out.println("> " + s);
    }
    System.out.println("--------------------");
  }

  public static void main(String[] args) {
    List<String> names = Arrays.asList("Fred", "Jim", "Sheila");
    showAll(names);
    showAll(getMatchingStrings(names, new LongText()));

    List<StringBuilder> moreNames = Arrays.asList(
        new StringBuilder("Freddy"),
        new StringBuilder("William"),
        new StringBuilder("Alf")
    );
    showAll(getMatchingStrings(moreNames, new LongText()));

    showAll(map(names, new FirstThree()));
    List<Object> map = map(moreNames, new FirstThree());
    showAll(map);
   }
}

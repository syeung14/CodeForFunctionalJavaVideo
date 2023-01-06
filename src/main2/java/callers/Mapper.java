package callers;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class Mapper {
  public static <E, F> List<F> map(List<E> l, Function<? super E, ? extends F> op) {
    List<F> results = new ArrayList<>();
    for (E e : l) {
      results.add(op.apply(e));
    }
    return results;
  }

  public static <E> List<E> filter(List<E> l, Predicate<? super E> criterion) {
    List<E> results = new ArrayList<>();
    for (E e : l) {
      if (criterion.test(e)) {
        results.add(e);
      }
    }
    return results;
  }

  public static void main(String[] args) {
    List<String> names = List.of("Fred", "Jim", "Sheila");
    Predicate<CharSequence> longString = s -> s.length() > 3;
//    Predicate<String> longString = s -> s.length() > 3;
    System.out.println(filter(names, longString));

    List<StringBuilder> morenames = List.of(
        new StringBuilder("Freddy"), new StringBuilder("Jim"), new StringBuilder("Sheila"));

    Predicate<StringBuilder> longSB = s -> s.length() > 3;
    System.out.println(filter(morenames, longSB));

    System.out.println(filter(morenames, longString));
  }
}

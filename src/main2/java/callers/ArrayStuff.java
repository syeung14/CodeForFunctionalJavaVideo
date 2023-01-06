package callers;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.List;

public class ArrayStuff {

//  public static <E> E[] getAsArray(List<E> le, Class cl) {
  public static <E> E[] getAsArray(List<E> le, Class<? super E> cl) {
//    E[] res = new E[le.size()];
    E[] res = (E[]) Array.newInstance(cl, le.size());
    for (int i = 0; i < res.length; i++) {
      res[i] = le.get(i);
    }
    return res;
  }
  public static void main(String[] args) {
    List<String> names = List.of("Fred", "Jim", "Sheila");

//    Object [] sa = getAsArray(names);
//    String [] sa = getAsArray(names, LocalDate.class);
//    String [] sa = getAsArray(names, String.class);
    CharSequence [] sa = getAsArray(names, CharSequence.class);
    System.out.println(sa[0]);
    sa[1] = new StringBuilder("Interestong");
  }
}

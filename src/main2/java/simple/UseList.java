package simple;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class UseList {
  public static void breakAList(List l) {
    l.add(0, LocalDate.now());
  }

  public static void breakAnother(List l) {
    l.add("Hello!");
  }
  public static void main(String[] args) {
    // List is a list of any reference type (i.e. any Object)
    // Generic type params "vanish" at runtime, called "Type Erasure"
//    List<String> names = new ArrayList<String>(Arrays.asList(LocalDate.now(), "William"));
    // diamond operator says "type this according to context"
    List<String> names = new ArrayList<>(Arrays.asList(/*LocalDate.now(),*/ "William"));
//    List<String> names = new ArrayList(Arrays.asList(LocalDate.now(), "William"));

//    names = Collections.checkedList(names, String.class);
    names.add("Fred");
    names.add("Jim");
    names.add("Sheila");
    System.out.println("first name is " + names.get(0)); // That can't happen?!?!
    System.out.println(names);
    names.add("Alice");
//    names.add(LocalDate.now());
//    breakAList(names);
    System.out.println(names);
//    String nameTwo = (String)names.get(1);

    for (String s : names) {
      System.out.println("> " + s);
    }
//    String nameTwo = names.get(0); // Cast added by compiler :)

    List<LocalDate> ld = new ArrayList();
    breakAnother(ld);
//    LocalDate first = ld.get(0);

    // List<String> is a "non-reifiable" type. That is, it's not real :)
//    if (names instanceof List<String>) {
    if (names instanceof List) {
      System.out.println("It's a list");
    }

    String [] sa = {};
    System.out.println(sa.getClass().getName());
    if (sa instanceof String []) {
      System.out.println("yup, it's a String array");
    }

    int [] ia = { 1,2,3 };
    // no generics with primitives (yet)
//    List<int> li;
    List<Integer> li;
    List<int[]> lia;
  }
}

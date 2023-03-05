package simple;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class UseAList {

    public static void addToList(List l) {
        l.add(0, LocalDate.now());
    }

    public static void main(String[] args) {
        List<String> names = new ArrayList<>(Arrays.asList("Freddy"));
        names = Collections.checkedList(names, String.class);
        //    List<String> names = new ArrayList<String>(
        //        Arrays.asList(/*LocalDate.now(), */"Freddy"));
        names.add("Fred");
        names.add("Jim");
        names.add("Sheila");
        //    names.add(LocalDate.now());
        //    String s = (String)(names.get(0));
        addToList(names);
        String s = names.get(0); // CAST Still exists in compiled code.

        Class cl = s.getClass();
        System.out.println("Name of class of string is " + cl.getName());

        System.out.println("item at index zero is " + names.get(0));
        //    System.out.println("item at index zero is " + names.get(3));
    }
}

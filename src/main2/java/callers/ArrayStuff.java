package callers;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;

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
        new ArrayStuff().testSelectCri();

    }

    void preMain() {
        List<String> names = List.of("Fred", "Jim", "Sheila");

        //    Object [] sa = getAsArray(names);
        //    String [] sa = getAsArray(names, LocalDate.class);
        //    String [] sa = getAsArray(names, String.class);
        CharSequence[] sa = getAsArray(names, CharSequence.class);
        System.out.println(sa[0]);
        sa[1] = new StringBuilder("Interestong");
    }

    void testSelectCri() {
        List<String> names = List.of("Fred", "Jim", "Sheila");
        Predicate<String> longStr = s -> s.length() > 3;
        List<String> res = selectCri(names, longStr);

        System.out.println(res);

        List<StringBuilder> nsb = List.of(
            new StringBuilder("Alice"),
            new StringBuilder("Bob"),
            new StringBuilder("Trent")
        );


        Predicate<CharSequence> longChar = s -> s.length() > 3;
        List<StringBuilder> resb = selectCri(nsb, longChar);

    }

    static void testMapGeneric() {
        Function<String, Integer> getLen = s -> s.length();

        List<String> names = List.of("Fred", "Jim", "Sheila");
        List<Number> ln = map(names, getLen);


        List<StringBuilder> nsb = List.of(
            new StringBuilder("Alice"),
            new StringBuilder("Bob"),
            new StringBuilder("Trent")
        );
        Function<CharSequence, Integer> getLenCS = s -> s.length();
        ln = map(nsb, getLenCS);

        Map<String, String> nameMap = Map.of("", "");

        Comparator<Map.Entry<String, String>> value =
            Map.Entry.<String, String>comparingByValue().reversed();


    }

    public static <E, F> List<F> map(List<E> input, Function<? super E, ? extends F> op) {
        List<F> res = new ArrayList<>();
        for (E e : input) {
            res.add(op.apply(e));
        }
        return res;
    }


    static <E> List<E> selectCri(List<E> input, Predicate<? super E> test) {
        List<E> res = new ArrayList<>();

        for (E e : input) {
            if (test.test(e)) {
                res.add(e);
            }
        }

        return res;
    }
}

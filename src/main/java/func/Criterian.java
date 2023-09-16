package func;

import java.util.Comparator;
import java.util.function.Predicate;
import java.util.function.ToIntFunction;

public interface Criterian<E> {

    interface CarCriterion<E> {
        boolean test(E c);
    }

    default <E> CarCriterion<E> negate(CarCriterion<E> crit) {
        return x -> !crit.test(x);
    }

    //    public static <E> CarCriterion<E> negate(CarCriterion<E> crit) {
    //        return  x -> !crit.test(x);
    //    }

    //a adaptor pattern
    public static <E> ToIntFunction<E> compareWithThis(E target, Comparator<E> comp) {
        //E as the input and returns and int value
        return x -> comp.compare(target, x);
    }

    //an adaptor pattern
    public static <E> Predicate<E> compareGreater(ToIntFunction<E> comp) {
        return x -> comp.applyAsInt(x) < 0;
    }
}

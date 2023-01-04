package func;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class SuperIterable<E> implements Iterable<E> {
    private Iterable<E> self;

    public SuperIterable(Iterable<E> s) {
        this.self = s;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    public SuperIterable<E> filter(Predicate<E> pred) {
        List<E> res = new ArrayList<>();

        self.forEach(e -> {
            if (pred.test(e)) res.add(e);
        });
//        for (E e : self) {
//            if (pred.test(e)) {
//                res.add(e);
//            }
//        }
        return new SuperIterable<>(res);
    }

    public void forEvery(Consumer<E> cons) {
        for (E e : self) {
            cons.accept(e);
        }
    }

    public <F> SuperIterable<F> flatMap(Function<E, SuperIterable<F>> op) {
        List<F> res = new ArrayList<>();
        self.forEach(e -> op.apply(e).forEach(f -> res.add(f)));
        return new SuperIterable<>(res);
    }

    public <F> SuperIterable<F> map(Function<E, F> op) {
        List<F> res = new ArrayList<>();
        self.forEach(e -> res.add(op.apply(e)));
        return new SuperIterable<>(res);
    }
}
package func;

import java.util.OptionalInt;
import java.util.stream.IntStream;

public class SumIntStream {
    public static void main(String[] args) {
//        OptionalInt sum = IntStream.iterate(0, i -> i + 1)
//                .reduce((a, b) -> a + b)
//                .forEach(i -> System.out.println("> " + i));

//        sum.ifPresent(r -> System.out.println("sum is " + r));

        OptionalInt res = IntStream.iterate(0, i -> i + 1)
            .limit(10)
            .reduce((a, b) -> a + b);

        res.ifPresent(r -> System.out.println(" Sum is " + r));
    }

}

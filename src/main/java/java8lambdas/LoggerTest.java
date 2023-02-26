package java8lambdas;

import functional.Car;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Stream;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toList;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class LoggerTest {

    public static void main(String[] args) {
        new LoggerTest().lookList();
    }


    void lookList() {
        List<Car> list = asList(
            Car.withGasColorPassengers(6, "Red", "Fred", "Jim", "Sheila"),
            Car.withGasColorPassengers(3, "Octarine", "Rincewind", "Ridcully"),
            Car.withGasColorPassengers(9, "Black", "Weatherwax", "Magrat"),
            Car.withGasColorPassengers(7, "Green", "Valentine", "Gillian", "Anne", "Dr. Mahmoud"),
            Car.withGasColorPassengers(6, "Red", "Ender", "Hyrum", "Locke", "Bonzo")
        );
        long count = list.stream().filter(c -> c.getColor().equals("Red")).count();
        System.out.println(count);

    }


    @Test
    void testMap() {
        List<String> collected = Stream.of("a", "b", "hello")
                                       .map(s -> s.toUpperCase())
                                       .collect(toList());
        assertEquals(asList("A", "B", "HELLO"), collected);


        List<Integer> together = Stream.of(asList(1, 2), asList(3, 4))
                                       .flatMap(numbers -> numbers.stream())
                                       .collect(toList());
    }

    @Test
    void test() {
        List<String> collected = Stream.of("a", "b", "c").collect(toList());
        assertEquals(asList("a", "b", "c"), collected);
    }
}

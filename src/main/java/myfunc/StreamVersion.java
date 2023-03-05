package myfunc;

import functional.Car;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamVersion {

    public static void main(String[] args) {
        List<String> strings = Arrays.asList(
            "LightCoral", "pink", "Orange", "Gold", "plum", "Blue", "limegreen");

        strings.stream().forEach(s -> System.out.println(s));

        Stream<String> uppcase =
            strings.stream().filter(s -> Character.isUpperCase(s.charAt(0)));

        System.out.println(uppcase);

        uppcase.forEach(System.out::println);

        System.out.println("----------------------------------------------------");
        strings.stream()
            .filter(x -> Character.isUpperCase(x.charAt(0)))
            .map(x -> x.toUpperCase())
            .forEach(x -> System.out.println(x));


        List<Car> fleet = Arrays.asList(
            Car.withGasColorPassengers(6, "Red", "Fred", "Jim", "Sheila"),
            Car.withGasColorPassengers(3, "Octarine", "Rincewind", "Ridcully"),
            Car.withGasColorPassengers(9, "Black", "Weatherwax", "Magrat"),
            Car.withGasColorPassengers(7, "Green", "Valentine", "Gillian", "Anne", "Dr. Mahmoud"),
            Car.withGasColorPassengers(6, "Red", "Ender", "Hyrum", "Locke", "Bonzo")
        );

        System.out.println("----------------------------------------------------");
        fleet.stream()
            .filter(c -> c.getGasLevel() > 6)
            .map(c -> c.getPassengers().get(0) + " is driving a " + c.getColor() + " car with lots fuel.")
            .forEach( c -> System.out.println("> " + c));

        System.out.println("----------------------------------------------------");
        fleet.stream()
                 .map(c -> c.addGas(5))
                     .forEach(c -> System.out.println(c));

        System.out.println("----------------------------------------------------");
        fleet.stream()
            .filter(c -> c.getPassengers().size() > 3)
            .flatMap(c -> c.getPassengers().stream())
            .map(s -> s.toUpperCase())
            .forEach(s -> System.out.println(s));


    }

}

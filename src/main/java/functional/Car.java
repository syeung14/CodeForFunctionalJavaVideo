package functional;

import java.util.*;
import java.util.function.Predicate;

public class Car {

    private final int gasLevel;
    private final String color;
    private final List<String> passengers;
    private final List<String> trunkContents;

    private Car(int gasLevel, String color, List<String> passengers, List<String> trunkContents) {
        this.gasLevel = gasLevel;
        this.color = color;
        this.passengers = passengers;
        this.trunkContents = trunkContents;
    }

    public static Car withGasColorPassengers(int gas, String color, String... passengers) {
        List<String> p = Collections.unmodifiableList(Arrays.asList(passengers));
        Car self = new Car(gas, color, p, null);
        return self;
    }

    public static Car withGasColorPassengersAndTrunk(int gas, String color, String... passengers) {
        List<String> p = Collections.unmodifiableList(Arrays.asList(passengers));
        Car self = new Car(gas, color, p, Arrays.asList("jack", "wrench", "spare wheel"));
        return self;
    }

    public int getGasLevel() {
        return gasLevel;
    }

    public Car addGas(int g) {
        return new Car(gasLevel + g, color, passengers, trunkContents);
    }

    public String getColor() {
        return color;
    }

    public List<String> getPassengers() {
        return passengers;
    }

    public List<String> getTrunkContents() {
        return trunkContents;
    }

    public Optional<List<String>> getTrunkContentsOpt() {
        return Optional.ofNullable(trunkContents);
    }

    @Override
    public String toString() {
        return "Car{" + "gasLevel=" + gasLevel + ", color=" + color + ", passengers=" + passengers
                + (trunkContents != null ? ", trunkContents=" + trunkContents : " no trunk") + '}';
    }

    public static Predicate<Car> getColorCriterion(String... colors) {
        Set<String> colorSet = new TreeSet<>(Arrays.asList(colors));
        return c -> colorSet.contains(c.getColor());
    }

    public static Criterion<Car> getColorCriterion2(String... colors) {
        Set<String> colorset = new HashSet<>(Arrays.asList(colors));
        return (c) -> colorset.contains(c.color);

    }

    public static Predicate<Car> getRedCarCriterion() {
        return RED_CAR_CRITERION;
    }

    private static final Predicate<Car> RED_CAR_CRITERION
            = c -> c.color.equals("Red");

    public static Predicate<Car> getGasLevelCarCriterion(final int threshold) {
        return c -> c.gasLevel >= threshold;
    }

    public static Predicate<Car> getFourPassengerCriterion() {
        return c -> c.passengers.size() >= 4;
    }

    public static Comparator<Car> getFuelComparator() {
        return fuelComparator;
    }

    private static final Comparator<Car> fuelComparator = (o1, o2) -> o1.gasLevel - o2.gasLevel;

    /***************************************************************************************/

    //factory method
    public static Criterion getRedCarCriterion2() {
        return RED_CAR_CRITERION_2; //always the same object --- singleton
    }

    static final RedCarCriterion RED_CAR_CRITERION_2 = new RedCarCriterion();

    static final Criterion<Car> RED_CAR_CRITERION_3 = (c) -> c.color.equals("Red");

    @FunctionalInterface //to have exact one abstract method
    public interface Criterion<E> {
        boolean test(E c);
    }

    //use static as this property is shared among all instances
    private static class RedCarCriterion implements Criterion<Car> {
        @Override
        public boolean test(Car c) {
            return c.color.equals("Red");
        }
    }

    public static Criterion<Car> getByCriterion(int threshold) {
/*
        return new CarCriterion() {
            @Override
            public boolean test(Car c) {
                return c.gasLevel >= threshold;
            }
        };
*/
        return (c) -> c.gasLevel >= threshold;
    }

    public static Comparator<Car> getGasComparator() {
        return gasComparator2;
    }

    private static final Comparator<Car> gasComparator2 = new CarGasComparator2();

    private static class CarGasComparator2 implements Comparator<Car> {
        @Override
        public int compare(Car o1, Car o2) {
            return o1.gasLevel - o2.gasLevel;
        }
    }

    private static class GasLvlCarCriterion implements Criterion<Car> {
        int threshold;

        public GasLvlCarCriterion(int threshold) {
            this.threshold = threshold;
        }

        @Override
        public boolean test(Car c) {
            return c.gasLevel >= threshold;
        }
    }

}

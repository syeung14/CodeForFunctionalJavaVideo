package func;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;
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

  public static Predicate<Car> getColorCriterion(String ... colors) {
    Set<String> colorSet = new TreeSet<>(Arrays.asList(colors));
    return c -> colorSet.contains(c.getColor());
  }
  
  public static Predicate<Car> getRedCarCriterion() { //factor pattern
    return RED_CAR_CRITERION;
  }

  private static final Predicate<Car> RED_CAR_CRITERION = c -> c.color.equals("Red");

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

  public static CarCriterion getGasLevelCriterion(int threshold) {
    return new CarCriterion<Car>() { //could be further reduced with Lambda
      @Override
      public boolean test(Car  c) {
        return c.gasLevel >= threshold;
      }
    };
  }

//  private static class GasLevelCarCriterion implements CarCriterion<Car> {
//    private int threshold;
//
//    public GasLevelCarCriterion(int threshold) {
//      this.threshold = threshold;
//    }
//
//    @Override
//    public boolean test(Car c) {
//      return c.getGasLevel() >= threshold;
//    }
//  }

  public static final CarCriterion<Car> RED_CAR_CRITERION_V2 = (c) -> c.getColor().equals("Red");

  private class RedCarCriterion implements CarCriterion<Car> {
    @Override
    public boolean test(Car c) {
      return c.getColor().equals("Red");
    }
  }

  public static Comparator<Car> getGasComparator() {
    return gasComparator;
  }

//  private static final Comparator<Car> gasComparator = (a, b) ->Integer.compare(a.getGasLevel(), b.getGasLevel());
  private static final Comparator<Car> gasComparator = Comparator.comparingInt(Car::getGasLevel);

  private static class CarGasComparator implements Comparator<Car> {
    @Override
    public int compare(Car o1, Car o2) {
      return Integer.compare(o1.gasLevel, o2.gasLevel);
    }
  }

  public static CarCriterion<Car> getColorCriterionV2(String... colors) {
    Set<String> colorSet = new HashSet<>(Arrays.asList(colors));
    return c -> colorSet.contains(c.color);
  }
}

@FunctionalInterface
interface CarCriterion<E> {
  boolean test(E c);
}

interface Strange {
  boolean stuff(Car c);
}
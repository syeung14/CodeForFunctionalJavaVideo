package func;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.function.ToIntFunction;

public class CarScratch {
  
  public static <E> ToIntFunction<E> compareWithThis(E target, Comparator<E> comp) {
    return x -> comp.compare(target, x);
  }
  
  public static <E> Predicate<E>  comparesGreater(ToIntFunction<E> comp) {
    return x -> comp.applyAsInt(x)  < 0;
  } //
  
  public static <E> void showAll(List<E> lc) {
    for (E c : lc) {
      System.out.println(c);
    }
    System.out.println("-------------------------------------");
  }

  static class PassengerCounterOrder implements Comparator<Car> {
    @Override
    public int compare(Car o1, Car o2) {
      return Integer.compare(o1.getPassengers().size(), o2.getPassengers().size());
    }
  }

  /**
   * Predicate is the behavior
   */
  public static <E> List<E> filter(Iterable<E> lc, Predicate<E> criterion) {
    List<E> rv = new ArrayList<>();
    for (E c : lc) {
      if (criterion.test(c)) {
        rv.add(c);
      }
    }
    return rv;
  }

  public static List<Car> getCaraByCriterion(Iterable<Car> lc, CarCriterion crit) {
    List<Car> output = new ArrayList<>();
    for (Car c : lc) {
      if (crit.test(c)) {
        output.add(c);
      }
    }
    return output;
  }

  public static <E> CarCriterion<E> negate(CarCriterion<E> crit) {
    return  x -> !crit.test(x);
  }

  public static void main(String[] args) {
    List<Car> cars = Arrays.asList(
        Car.withGasColorPassengers(6, "Red", "Fred", "Jim", "Sheila"),
        Car.withGasColorPassengers(3, "Octarine", "Rincewind", "Ridcully"),
        Car.withGasColorPassengers(9, "Black", "Weatherwax", "Magrat"),
        Car.withGasColorPassengers(7, "Green", "Valentine", "Gillian", "Anne", "Dr. Mahmoud"),
        Car.withGasColorPassengers(6, "Red", "Ender", "Hyrum", "Locke", "Bonzo")
    );

    showAll(cars);
    showAll(getCaraByCriterion(cars, func.Car.RED_CAR_CRITERION_V2));
    showAll(getCaraByCriterion(cars, func.Car.getGasLevelCriterion(6)));

    cars.sort(func.Car.getGasComparator());
    showAll((cars));

    showAll(getCaraByCriterion(cars, func.Car.getColorCriterionV2("Red", "Black")));

    Car john = Car.withGasColorPassengers(5, "BLue");
    ToIntFunction<Car> compareWithBert = Criterian.compareWithThis(john, func.Car.getGasComparator());
    for (Car c : cars) {
      System.out.println(compareWithBert.applyAsInt(c));
    }
  }
}

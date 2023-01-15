package ch12.demon5;

import java.util.List;

public class Test1 {

    public static void addElementsVersion2(List<Object> mylist) {
        mylist.add(new Vehicle1Test());
        mylist.add(new Sub1VehicleTest());
        mylist.add(null);
    }

    /**
     * The type whose information is completely available during runtime is called a reifiable type.
     */
    public static void addElementsVersion1(List<?> mylist) {
//        mylist.add(new Vehicle1Test());
//        mylist.add(new Sub1VehicleTest());
        mylist.add(null);
    }

    public static void printElements(List<?> mylist) {
        mylist.forEach(e -> System.out.println(e));
    }

    public static void main(String[] args) {

    }
}

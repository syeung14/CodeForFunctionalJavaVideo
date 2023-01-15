package ch12.demon5;

import java.util.ArrayList;
import java.util.List;

class Vehicle {
    static int basicVehicleCount;

    public void constructBody() {
        basicVehicleCount++;
        System.out.println("One basic structure is formed.No of basic structure =" + basicVehicleCount);
    }
}


class Bus extends Vehicle {
    static int busCount;

    public void constructBody() {
        busCount++;
        System.out.println("Bus completed.It can move on road now. The bus count=" + busCount);
    }
}

class Rocket extends Vehicle {
    static int rocketCount;

    @Override
    public void constructBody() {
        rocketCount++;
        System.out.println("Rocket constructed.It can move into space now. The rocket count=" + rocketCount);
    }
}

public class Demonstration5 {
    public static void constructAllVehicles_old(List<? extends Vehicle> vehicles) {
        System.out.println("Here is the vehicle list of you:");
        vehicles.forEach((v) -> v.constructBody());
    }

    public static void constructAllVehicles_v2(List<? super Bus> vehicles) {
        System.out.println("Here is the vehicle list of you:");
        vehicles.forEach((v) -> ((Vehicle)v).constructBody());
    }

    public static void constructAllVehicles(List<?> vehicles) {
        System.out.println("Here is the vehicle list of you:");
        vehicles.forEach((v) -> ((Vehicle)v).constructBody());
    }

    public static void main(String[] args) {
        System.out.println("***Demonstration-5.Use of Wildcard types in generic programming.***");
        //One Vehicle object
        Vehicle vehicle1 = new Vehicle();
        // Three Bus objects
        Bus bus1 = new Bus();
        Bus bus2 = new Bus();
        Bus bus3 = new Bus();
        // Two Rocket objects
        Rocket rocket1 = new Rocket();
        Rocket rocket2 = new Rocket();

        List<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(vehicle1);
        vehicles.add(bus1);
        vehicles.add(rocket1);
        constructAllVehicles(vehicles);

        List<Bus> buses = new ArrayList<>();
        buses.add(bus1);
        buses.add(bus2);
        buses.add(bus3);
        constructAllVehicles(buses);

        List<Rocket> rockets = new ArrayList<>();
        rockets.add(rocket1);
        rockets.add(rocket2);
        constructAllVehicles(rockets);

    }
}

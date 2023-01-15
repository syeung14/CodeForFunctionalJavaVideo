package ch12.demon10;

import ch12.demon2.MyGenericClass;

import java.awt.dnd.DropTargetAdapter;

public class Demonstration10 {
    public static void main(String[] args) {
        MyGenericClass<Double> doubleOb = new MyGenericClass<>();
        double d1 = doubleOb.show(100.5);
        System.out.println("teh method show returns the double value:" + d1);


        MyGenericClass rawOb = new MyGenericClass();
        doubleOb = rawOb;
    }
}

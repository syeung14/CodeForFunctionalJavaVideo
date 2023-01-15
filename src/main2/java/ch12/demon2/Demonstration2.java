package ch12.demon2;

public class Demonstration2 {
    public static void main(String[] args) {
        System.out.println("----------");
        MyGenericClass<Integer> myIntOb = new MyGenericClass<>();
        System.out.println(myIntOb.show(100));

        MyGenericClass<String> myStrob = new MyGenericClass<>();
        System.out.println("The method stirng: " + myStrob.show("A generic method is called"));
    }
}

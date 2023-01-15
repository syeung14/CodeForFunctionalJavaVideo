package ch12.demon7;

public class Demonstration7 {
    public static void main(String[] args) {
        GenericDemo7Class<Double> doubleOb = new GenericDemo7Class<>(2.5, 5.7);
        System.out.println("2.5+5.7=" + doubleOb.displaySum());

        GenericDemo7Class<Integer> intob = new GenericDemo7Class<>(2, 7);
        System.out.println("2+7=" + doubleOb.displaySum());

//        GenericDemo7Class<String> strOb =new GenericDemo7Class<>("H", "W");

    }
}


class GenericDemo7Class<T extends Number> {
    T firstNumber, secondNumber;

    GenericDemo7Class(T firstNumber, T secondNumber) {
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
    }

    public double displaySum() {
        return firstNumber.doubleValue() + secondNumber.doubleValue();
    }

}
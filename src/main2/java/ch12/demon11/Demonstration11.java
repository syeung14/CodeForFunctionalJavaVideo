package ch12.demon11;

import ch12.demon2.MyGenericClass;

class SubClass<T> extends MyGenericClass<T> {
}

class SubClass1<V, T> extends MyGenericClass<T> {

    public V subMethod(V value) {
        return value;
    }
}

public class Demonstration11 {
    public static void main(String[] args) {

    }
}

class SubClass2<V> extends MyGenericClass<Integer> {

    public V subMethod(V value) {
        return value;
    }
}

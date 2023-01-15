package ch12.demon6;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Test2 {
    public static void main(String[] args) {
        Sample sample = new Sample();
        List<?> myList = Arrays.asList(12, 27, 39);
        System.out.println("Original list: " + myList);
        Collections.reverse(myList);
        System.out.println("reversed List: " + myList);
        sample.validMethodWithWidCardParameter(myList);
    }
}


class Sample {
    List<?> myList;

    public void validMethodWithWidCardParameter(List<?> myParameter) {
        System.out.println("The validMethodWithWildCardParameter(List<?> myParameter) is a valid method.");
    }

}

//Case Study-4:Wildcards in supertype
//Error: A supertype may not specify any wild card
//public class SubList implements List<?>{ //Invalid
//Some code
//}
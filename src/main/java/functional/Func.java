package functional;

import java.util.HashMap;
import java.util.Map;

public class Func {

    void method() {
        Thread t = new Thread("");

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("in thread");
            }
        }).start();


        Map<String, String> map = new HashMap<>();
        map.forEach((k, v) -> System.out.println(k = " - " + v));


    }
}

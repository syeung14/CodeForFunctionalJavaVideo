package functional;

import com.google.common.collect.ImmutableSet;
import org.junit.Test;

public class GuavaTest {


    @Test
    public void testGuava() {
        ImmutableSet<String> COLOR_NAMES = ImmutableSet.of(
            "red",
            "orange",
            "yellow",
            "green",
            "blue",
            "purple");

        System.out.println(COLOR_NAMES);
    }

}

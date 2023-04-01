package func;

import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.DoubleStream;

class Average {

    private double total;
    private long count;

    public Average() {
    }

    public void include(double d) {
        total += d;
        count++;
    }

    public void merge(Average other) {
        this.total += other.total;
        this.count += other.count;
    }

    public double get() {
        return total /count;
    }
}

public class CollectAverage {

    public static void main(String[] args) {
        long start = System.nanoTime();

        Average avg = DoubleStream.generate(() -> ThreadLocalRandom.current().nextDouble(-Math.PI, Math.PI))
            .parallel()
            .limit(1000)
            .map(Math::sin)
            .collect(Average::new, Average::include, Average::merge);

        long end = System.nanoTime();
        double mean = avg.get();
        System.out.println("avg: " + mean);
        System.out.println("Time: " + (end - start)/1_000_000);

    }
}

package functional;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.Map;
import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Concordance {
  private static final Pattern WORD_BREAK = Pattern.compile("\\W+");
  private static final Comparator<Map.Entry<String, Long>> valueOrder =
      Map.Entry.comparingByValue();
  
  public static void main(String[] args) throws IOException {
    try (Stream<String> lines = Files.lines(Paths.get("PrideAndPrejudice.txt"))) {
      lines
          .map(s -> s.toLowerCase())
          .flatMap(w -> WORD_BREAK.splitAsStream(w))
          .filter(s -> s.length() > 0)
          .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
          .entrySet().stream()
          .sorted(valueOrder.reversed())
          .limit(200)
          .forEach(e -> System.out.printf("%20s : %5d\n", e.getKey(), e.getValue()));
    }
  }
}

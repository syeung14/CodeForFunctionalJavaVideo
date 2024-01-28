package org.paumard.streams;

import org.paumard.streams.model.City;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ComputeStatistics2 {

    public static void main(String[] args) {

        Function<String, City> lineToCity =
            line -> {
                String[] split = line.split(";");
                String cityName = split[1].trim();
                String state = split[2].trim();
                String populationAsString = split[3];
                populationAsString = populationAsString.replace(" ", "");
                int populatoin = Integer.parseInt(populationAsString);

                String landAreaAsString = split[4];
                landAreaAsString = landAreaAsString.replace(" ", "").replace(',', '.');
                double landArea = Double.parseDouble(landAreaAsString);

                return new City(cityName, state, populatoin, landArea);
            };

        Path path = Path.of("data/cities.csv");
        Set<City> cities = null;
        try (Stream<String> lines = Files.lines(path, StandardCharsets.ISO_8859_1);) {
            cities = lines.skip(2).map(lineToCity).collect(Collectors.toSet());
        } catch (IOException e) {
            throw new RuntimeException(e); // TODO
        } //

        String utah = "ï¿½Utah";
        System.out.println("Citiy size" + cities.size());

        Map<String, List<City>> citiesPerState =
            cities.stream()
                  .collect(Collectors.groupingBy(c -> c.getState()));

        System.out.println("Map Size: " + citiesPerState.size());
        List<City> citiesOfUtah = citiesPerState.get(utah);
        System.out.println(citiesOfUtah);

        Map<String, Long> numberOfCitiesPerState =
            cities.stream().collect(Collectors.groupingBy(c -> c.getState(), Collectors.counting()));

        System.out.println("Cities in utah:" + numberOfCitiesPerState.get(utah));

        Map.Entry<String, Long> stateWithMostCities =
            numberOfCitiesPerState.entrySet().stream()
//                .max(Entry.comparingByValue())
                .max(Comparator.comparing(Entry::getValue))
                .orElseThrow();

        System.out.println(stateWithMostCities);

        int populationOfUtah =
            citiesPerState.get(utah).stream()
                .collect(Collectors.summingInt(c -> c.getPopulation()));

        System.out.println("Population of utah:" + populationOfUtah);

        Map<String, Integer> populationOfCitiesPerState =
            cities.stream()
                .collect(
                    Collectors.groupingBy(
                        c -> c.getState(),
                        Collectors.summingInt(c -> c.getPopulation())
                    )
                );
        System.out.printf("population of utah: " + populationOfCitiesPerState.get(utah));

        Map.Entry<String, Integer> stateWithTheMostPeople =
            populationOfCitiesPerState.entrySet().stream()
                .max(Entry.comparingByValue())
                .orElseThrow();

        System.out.println(stateWithTheMostPeople);

    }

}

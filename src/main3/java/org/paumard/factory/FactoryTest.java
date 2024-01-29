package org.paumard.factory;

import org.junit.Test;
import org.paumard.streams.model.City;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class FactoryTest {

    @Test
    public void testFactory() {

        Factory<City> fact = () -> new City("", "", 5, 2.2);
        List<City> list = fact.createe5();

        System.out.println(list);

    }

}
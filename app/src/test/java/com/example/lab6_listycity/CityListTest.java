package com.example.lab6_listycity;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class CityListTest {
    private CityList mockCityList() {
        CityList cityList = new CityList();
        cityList.add(mockCity());
        return cityList;
    }

    private City mockCity() {
        return new City("Edmonton", "Alberta");
    }

    @Test
    public void testAdd() {
        CityList cityList = mockCityList();
        assertEquals(1, cityList.getCities().size());
        City city = new City("Regina", "Saskatchewan");
        cityList.add(city);
        assertEquals(2, cityList.getCities().size());
        assertTrue(cityList.getCities().contains(city));
    }

    @Test
    public void testAddException() {
        CityList cityList = mockCityList();
        City city = new City("Yellowknife", "Northwest Territories");
        cityList.add(city);
        assertThrows(IllegalArgumentException.class, () -> {
            cityList.add(city);
        });
    }

    @Test
    public void testGetCities() {
        CityList cityList = mockCityList();
        // This line checks if the first city in the cityList (retrieved by cityList.getCities().get(0))
        // is the same as the city returned by mockCity()
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(0)));
        // This pushes down the original city
        City city = new City("Charlottetown", "Prince Edward Island");
        cityList.add(city);
        // Now the original city should be at index 1
        assertEquals(0, city.compareTo(cityList.getCities().get(0)));
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(1)));
    }

    @Test
    public void testHasCity() {
        CityList cityList = mockCityList();
        assertTrue(cityList.hasCity(mockCity()));
        City city1 = new City("Charlottetown", "Prince Edward Island");
        cityList.add(city1);
        assertTrue(cityList.hasCity(city1));
        City city2 = new City("Yellowknife", "Northwest Territories");
        assertFalse(cityList.hasCity(city2));
    }

    @Test
    public void testCountCities() {
        CityList cityList = mockCityList();
        assertEquals(1, cityList.countCities());
        City city1 = new City("Charlottetown", "Prince Edward Island");
        cityList.add(city1);
        City city2 = new City("Yellowknife", "Northwest Territories");
        cityList.add(city2);
        assertEquals(3, cityList.countCities());
    }

    @Test
    public void testDeleteCity() {
        CityList cityList = mockCityList();
        assertTrue(cityList.hasCity(mockCity()));
        cityList.delete(mockCity());
        assertFalse(cityList.hasCity(mockCity()));
        City city1 = new City("Charlottetown", "Prince Edward Island");
        cityList.add(city1);
        assertTrue(cityList.hasCity(city1));
        City city2 = new City("Yellowknife", "Northwest Territories");
        cityList.add(city2);
        assertTrue(cityList.hasCity(city2));
        cityList.delete(city1);
        cityList.delete(city2);
        assertFalse(cityList.hasCity(city1));
        assertFalse(cityList.hasCity(city2));
    }

    @Test
    public void testDeleteException() {
        CityList cityList = mockCityList();
        City city = new City("Charlottetown", "Prince Edward Island");
        assertThrows(IllegalArgumentException.class, () -> {
            cityList.delete(city);
        });
    }
}

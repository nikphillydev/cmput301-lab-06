package com.example.lab6_listycity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * This is a class that keeps a list of city objects.
 */
public class CityList {
    private List<City> cities = new ArrayList<>();

    /**
     * This adds a city to the list if the city does not exist.
     * If city does exist then throws {@link IllegalArgumentException}
     * @param city      candidate city to add
     */
    public void add(City city) {
        if (cities.contains(city)) {
            throw new IllegalArgumentException();
        }
        else {
            cities.add(city);
        }
    }

    /**
     * This returns a sorted list of cities
     * @return          the sorted list
     */
    public List<City> getCities() {
        List<City> list = cities;
        Collections.sort(list);
        return list;
    }

    /**
     * This returns true if city belongs in the list
     * @param city      candidate city to check
     * @return          true if city is in list, false otherwise
     */
    public boolean hasCity(City city) {
        return cities.contains(city);
    }

    /**
     * This returns the number of cities in the list
     * @return          number of cities
     */
    public int countCities() {
        return cities.size();
    }

    /**
     * This removes a city from the list if it is present.
     * If city is not present then throws {@link IllegalArgumentException}
     * @param city      candidate city to delete
     */
    public void delete(City city) {
        if (cities.contains(city)) {
            cities.remove(city);
        }
        else {
            throw new IllegalArgumentException();
        }
    }
}

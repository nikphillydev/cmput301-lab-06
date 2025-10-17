package com.example.lab6_listycity;

import java.util.Comparator;

/**
 * This is a class that defines a city.
 */
public class City implements Comparable {
    private String city;
    private String province;
    City (String city, String province) {
        this.city = city;
        this.province = province;
    }

    /**
     * This returns the name of the city
     * @return      city name
     */
    public String getCityName() {
        return this.city;
    }

    /**
     * This returns the name of the province
     * @return      province name
     */
    public String getProvinceName() {
        return this.province;
    }

    /**
     * Compares this city to another city for ordering.
     * Cities are ordered lexicographically by their city names.
     *
     * @param o         the object to compare to
     * @return          a negative integer, zero, or a positive integer as this city's name
     *                  is lexicographically less than, equal to, or greater than the specified city's name
     * @throws ClassCastException       if the specified object is not a {@link City}
     */
    @Override
    public int compareTo(Object o) {
        City city = (City) o;
        return this.getCityName().compareTo(city.getCityName());
    }

    /**
     * Determines whether this city is equal to another object.
     * Two cities are considered equal if both their city names and province names are the same.
     *
     * @param o         the object to compare with this city
     * @return          true if the specified object is a {@link City} with the same city
     *                  and province names as this one; false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        City city = (City) o;
        boolean city_ok = this.getCityName().equals(city.getCityName());
        boolean prov_ok = this.getProvinceName().equals(city.getProvinceName());
        return city_ok && prov_ok;
    }
}

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
     * This returns the city attribute
     * @return      city name
     */
    String getCityName() {
        return this.city;
    }

    /**
     * This returns the province attribute
     * @return      province name
     */
    String getProvinceName() {
        return this.province;
    }

    @Override
    public int compareTo(Object o) {
        City city = (City) o;
        return this.getCityName().compareTo(city.getCityName());
    }

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

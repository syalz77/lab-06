package com.example.listycity;

import java.util.Objects;

/**
 * This is a class that defines a City.
 */
public class City implements Comparable<City> {


    /**
     * Name of city
     */
    private String city;
    /**
     * Name of province
     */
    private String province;


    /**
     * Constructor function which creates a City object with city name and province name
     * @param city the name of city
     * @param  province the name of province
     */
    City(String city, String province) {
        this.city = city;
        this.province = province;
    }


    /**
     * Gets city name
     * @return city name
     */
    String getCityName() {
        return this.city;
    }

    /**
     * Gets province name
     * @return province name
     */
    String getProvinceName() {
        return this.province;
    }


    /**
     * Compares this city to another city for ordering
     * Cities are compared by city name
     * @param other the city to compare to
     * @return a negative integer, zero, or a positive integer when compared to specified city
     */
    @Override
    public int compareTo(City other) {
        return this.city.compareTo(other.getCityName());
    }

    /**
     * Compares this city to another object to check if they are equal
     * Two cities are equal if they have the same city name and province name
     * @param obj the object to compare to
     * @return true if the cities are equal, false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        City city_obj = (City) obj;
        return Objects.equals(city, city_obj.getCityName()) && Objects.equals(province, city_obj.getProvinceName());
    }


    /**
     * Returns a hash code value for the city
     * The hash code is computed based on the city name and province name
     * @return a hash code value for this city
     */
    @Override
    public int hashCode() {
        return Objects.hash(city, province);
    }



}

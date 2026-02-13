package com.example.listycity;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CityListTest {

    private CityList mockCityList() {
        CityList cityList = new CityList();
        cityList.add(mockCity());
        return cityList;
    }

    private City mockCity() {
        return new City("Edmonton", "Alberta");
    }


    @Test
    void testAdd() {
        CityList cityList = mockCityList();
        assertEquals(1, cityList.getCities().size());
        City city = new City("Regina", "Saskatchewan");
        cityList.add(city);
        assertEquals(2, cityList.getCities().size());
        assertTrue(cityList.getCities().contains(city));
    }

    @Test
    void testAddException() {
        CityList cityList = mockCityList();
        City city = new City("Yellowknife", "Northwest Territories");
        cityList.add(city);
        assertThrows(IllegalArgumentException.class, () -> {
            cityList.add(city);
        });
    }

    @Test
    void testGetCities() {
        CityList cityList = mockCityList();

        // This line checks if the first city in the cityList
        // (retrieved by cityList.getCities().get(0)) is the same as the city returned by mockCity()
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(0)));

        // Add a new city
        City city = new City("Charlottetown", "Prince Edward Island");
        cityList.add(city);

        // Now the original city should be at position 1
        assertEquals(0, city.compareTo(cityList.getCities().get(0)));
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(1)));
    }


    @Test
    void testHasCity() {

        CityList cityList = mockCityList();
        City city = new City("Vancouver", "British Columbia");
        cityList.add(city);
        assertTrue(cityList.hasCity(city));
        assertFalse(cityList.hasCity(new City("Calgary", "Alberta")));
    }

    @Test
    void testDelete() {

        CityList cityList = mockCityList();
        City city = new City("Ottawa", "Ontario");
        cityList.add(city);
        assertTrue(cityList.hasCity(city));
        cityList.delete(city);
        assertFalse(cityList.hasCity(city));

        assertThrows(IllegalArgumentException.class, () -> {
           cityList.delete(new City("Halifax", "Nova Scotia"));
        });
    }


    @Test
    void testCountCities() {

        CityList cityList = mockCityList();
        City city = new City("Victoria", "British Columbia");
        cityList.add(city);
        assertEquals(2, cityList.countCities());
        City city2 = new City("Winnipeg", "Manitoba");
        cityList.add(city2);
        assertEquals(3, cityList.countCities());

    }




}


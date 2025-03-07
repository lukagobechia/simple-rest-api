package com.gobechia.simple_api.dto;

public class CityDTO {
    private String cityName;
    private String countryName;

    public CityDTO(String cityName, String countryName) {
        this.cityName = cityName;
        this.countryName = countryName;
    }

    // Getters and setters
    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }
}

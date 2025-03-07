package com.gobechia.simple_api.controllers;

import com.gobechia.simple_api.entities.City;
import com.gobechia.simple_api.services.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("cities")
public class CityController {
    private final CityService cityService;

    @Autowired()
    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getCityWithCountry(@PathVariable Long id){
        return cityService.getCityWithCountry(id);
    }

    @PostMapping("/")
    public ResponseEntity<Object> createCity(@RequestBody City city) {
        return cityService.newCity(city);
    }
}

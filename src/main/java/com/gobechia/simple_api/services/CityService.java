package com.gobechia.simple_api.services;

import com.gobechia.simple_api.dto.CityDTO;
import com.gobechia.simple_api.entities.City;
import com.gobechia.simple_api.repositories.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service()
public class CityService {
    private final CityRepository cityRepository;

    @Autowired
    public CityService(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    public ResponseEntity<Object> getCityWithCountry(Long id) {
      Optional<CityDTO> cityObject =  cityRepository.findCityWithCountryById(id);

      if(cityObject.isPresent()){
          CityDTO cityDTO = cityObject.get();
          String response = cityDTO.getCityName() + ", " + cityDTO.getCountryName();
          return ResponseEntity.ok(response);
      } else {
          return ResponseEntity.status(404).body("City not found");
      }
    }

    public ResponseEntity<Object> newCity(City city) {
        cityRepository.save(city);
        return new ResponseEntity<>(city, HttpStatus.CREATED);
    }
}

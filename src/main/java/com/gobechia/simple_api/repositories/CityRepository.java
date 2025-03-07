package com.gobechia.simple_api.repositories;

import com.gobechia.simple_api.dto.CityDTO;
import com.gobechia.simple_api.entities.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface CityRepository extends JpaRepository<City, Long> {
    @Query("SELECT new com.gobechia.simple_api.dto.CityDTO(c.city, c.country) FROM City c WHERE c.id = :id")
    Optional<CityDTO> findCityWithCountryById(@Param("id") Long id);
}

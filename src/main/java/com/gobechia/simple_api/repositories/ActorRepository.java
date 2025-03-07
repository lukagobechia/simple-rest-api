package com.gobechia.simple_api.repositories;

import com.gobechia.simple_api.dto.ActorDTO;
import com.gobechia.simple_api.entities.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ActorRepository extends JpaRepository<Actor, Long> {

    @Query("SELECT new com.gobechia.simple_api.dto.ActorDTO(a.firstName, a.lastName) FROM Actor a")
    List<ActorDTO> getAllActorsWithOnlyNames();
}

package com.gobechia.simple_api.services;

import com.gobechia.simple_api.dto.ActorDTO;
import com.gobechia.simple_api.entities.Actor;
import com.gobechia.simple_api.repositories.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service()
public class ActorService {
    private final ActorRepository actorRepository;

    @Autowired
    public ActorService(ActorRepository actorRepository) {
        this.actorRepository = actorRepository;
    }

    public List<ActorDTO> getAllActorsWithOnlyNames() {
        List<ActorDTO> actors = actorRepository.getAllActorsWithOnlyNames();

        if (actors.isEmpty()) {
            throw new RuntimeException("No actors found");
        }

        return actors;
    }

    public ResponseEntity<Actor> newActor(Actor actor) {
        actorRepository.save(actor);
        return new ResponseEntity<>(actor, HttpStatus.CREATED);
    }
}

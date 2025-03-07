package com.gobechia.simple_api.controllers;

import com.gobechia.simple_api.dto.ActorDTO;
import com.gobechia.simple_api.entities.Actor;
import com.gobechia.simple_api.entities.City;
import com.gobechia.simple_api.services.ActorService;
import com.gobechia.simple_api.services.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("actors")
public class ActorController {
    private final ActorService actorService;

    @Autowired()
    public ActorController(ActorService actorService) {
        this.actorService = actorService;
    }

    @GetMapping("/")
    public List<ActorDTO> getAllActorsWithOnlyNames(){
        return this.actorService.getAllActorsWithOnlyNames();
    }

    @PostMapping("/")
    public  ResponseEntity<Actor> createActor(@RequestBody Actor actor) {
        return actorService.newActor(actor);
    }
}

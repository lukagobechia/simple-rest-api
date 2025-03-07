package com.gobechia.simple_api.controllers;

import com.gobechia.simple_api.dto.FilmDTO;
import com.gobechia.simple_api.entities.Film;
import com.gobechia.simple_api.services.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/films")
public class FilmController {

    private final FilmService filmService;

    @Autowired
    public FilmController(FilmService filmService) {
        this.filmService = filmService;
    }

    @GetMapping("/search")
    public ResponseEntity<List<FilmDTO>> searchFilms(
            @RequestParam(required = false) String title,
            @RequestParam(required = false) String description,
            @RequestParam(required = false) Integer releaseYear,
            @RequestParam(required = false) String language,
            @RequestParam int page,
            @RequestParam(defaultValue = "10") int size) {

        List<FilmDTO> films = filmService.searchFilms(title, description, releaseYear, language, page, size);

        if (!films.isEmpty()) {
            return new ResponseEntity<>(films, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/")
    public ResponseEntity<Object> createFilm(@RequestBody Film film){
        return filmService.newFilm(film);
    }
}

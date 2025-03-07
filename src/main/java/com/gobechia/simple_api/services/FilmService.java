package com.gobechia.simple_api.services;

import com.gobechia.simple_api.dto.FilmDTO;
import com.gobechia.simple_api.entities.Film;
import com.gobechia.simple_api.repositories.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FilmService {

    private final FilmRepository filmRepository;

    @Autowired
    public FilmService(FilmRepository filmRepository) {
        this.filmRepository = filmRepository;
    }

    public List<FilmDTO> searchFilms(String title, String description, Integer releaseYear, String language, int page, int size) {
        var films = filmRepository.searchFilms(title, description, releaseYear, language, PageRequest.of(page, size));

        return films.stream()
                .map(film -> {
                    FilmDTO filmDTO = new FilmDTO();
                    filmDTO.setTitle(film.getTitle());
                    filmDTO.setDescription(film.getDescription());
                    filmDTO.setRating(film.getRating());
                    return filmDTO;
                })
                .collect(Collectors.toList());
    }

    public ResponseEntity<Object> newFilm(Film film){
        filmRepository.save(film);
        return new ResponseEntity<>(film, HttpStatus.CREATED);
    }
}

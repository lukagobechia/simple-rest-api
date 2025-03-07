package com.gobechia.simple_api.repositories;

import com.gobechia.simple_api.entities.Film;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface FilmRepository extends JpaRepository<Film, Long> {

    @Query("SELECT f FROM Film f WHERE " +
            "(:title IS NULL OR f.title LIKE %:title%) AND " +
            "(:description IS NULL OR f.description LIKE %:description%) AND " +
            "(:releaseYear IS NULL OR f.releaseYear = :releaseYear) AND " +
            "(:language IS NULL OR f.language LIKE %:language%)")
    Page<Film> searchFilms(@Param("title") String title,
                           @Param("description") String description,
                           @Param("releaseYear") Integer releaseYear,
                           @Param("language") String language,
                           PageRequest pageRequest);
}

package org.adaschool.sistemareservasada.application.service;

import org.adaschool.sistemareservasada.domain.dto.MovieDTO;
import org.adaschool.sistemareservasada.domain.entity.Movie;
import org.adaschool.sistemareservasada.domain.repository.MovieRepository;
import org.springframework.stereotype.Service;

@Service
public record MovieService(MovieRepository movieRepository) {

    public void createMovie(MovieDTO movieDTO) {
        Movie movie = Movie.builder()
                .name(movieDTO.name())
                .genre(movieDTO.genre())
                .movieLengthMinutes(movieDTO.movieLengthMinutes())
                .build();
        movieRepository.save(movie);
    }
}
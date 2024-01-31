package org.adaschool.sistemareservasada.application.service;

import org.adaschool.sistemareservasada.domain.dto.MovieDTO;
import org.adaschool.sistemareservasada.domain.entity.Movie;
import org.adaschool.sistemareservasada.domain.repository.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

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
    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    public Movie getMovieById(Integer movieId) {
        return movieRepository.findById(movieId)
                .orElseThrow(() -> new NoSuchElementException("Movie not found"));
    }

    public void updateMovie(Integer movieId, MovieDTO movieDTO) {
        Movie movieToUpdate = getMovieById(movieId);
        movieToUpdate.setName(movieDTO.name());
        movieToUpdate.setGenre(movieDTO.genre());
        movieToUpdate.setMovieLengthMinutes(movieDTO.movieLengthMinutes());
        movieRepository.save(movieToUpdate);
    }

    public void deleteMovie(Integer movieId) {
        Movie movieToDelete = getMovieById(movieId);
        movieRepository.delete(movieToDelete);
    }
}
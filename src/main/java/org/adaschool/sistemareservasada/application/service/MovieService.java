package org.adaschool.sistemareservasada.application.service;

import org.adaschool.sistemareservasada.application.mapper.MovieMapper;
import org.adaschool.sistemareservasada.domain.dto.MovieDTO;
import org.adaschool.sistemareservasada.domain.entity.Movie;
import org.adaschool.sistemareservasada.domain.repository.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public record MovieService(
        MovieRepository movieRepository,
        MovieMapper mapper
) {

    public void createMovie(MovieDTO movieDTO) {
        // Convertir MovieDTO a Movie usando el mapper
        Movie movie = mapper.toEntity(movieDTO);
        movieRepository.save(movie);
    }

    public List<MovieDTO> getAllMovies() {
        List<Movie> movies =  movieRepository.findAll();
        return mapper.toDtoList(movies);
    }

    public MovieDTO getMovieById(Integer movieId) {
        // Obtener la película por su ID y convertirla a MovieDTO
        Movie movie = movieRepository.findById(movieId)
                .orElseThrow(() -> new NoSuchElementException("Movie not found"));
        return mapper.toDto(movie);
    }

    public void updateMovie(Integer movieId, MovieDTO movieDTO) throws Exception {
        movieRepository.findById(movieId).orElseThrow(()-> new Exception("DATA NOT FOUND"));
        Movie movie = mapper.toEntity(movieDTO);
        movieRepository.save(movie);
    }

    public void deleteMovie(Integer movieId) {
        Movie movieToDelete = movieRepository.findById(movieId)
                .orElseThrow(() -> new NoSuchElementException("Movie not found"));
        movieRepository.delete(movieToDelete);
    }
}
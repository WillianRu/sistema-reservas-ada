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
        Movie movie = mapper.toEntity(movieDTO);
        movieRepository.save(movie);
    }

    public List<MovieDTO> findAllMovies() {
        List<Movie> movies =  movieRepository.findAll();
        return mapper.toDtoList(movies);
    }

    public MovieDTO findMovieById(Integer id) throws Exception{
        Movie movie = movieRepository.findById(id)
                .orElseThrow(() -> new Exception("Movie not found"));
        return mapper.toDto(movie);
    }

    public void updateMovie(Integer id, MovieDTO movieDTO) throws Exception {
        movieRepository.findById(id).orElseThrow(()-> new Exception("DATA NOT FOUND"));
        Movie movie = mapper.toEntity(movieDTO);
        movie.setId(id);
        movieRepository.save(movie);
    }

    public void deleteMovie(Integer id) throws Exception{
        Movie movie = movieRepository.findById(id)
                .orElseThrow(() -> new Exception("Movie not found"));
        movieRepository.delete(movie);
    }
}
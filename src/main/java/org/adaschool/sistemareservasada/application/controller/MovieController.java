package org.adaschool.sistemareservasada.application.controller;

import org.adaschool.sistemareservasada.application.service.MovieService;
import org.adaschool.sistemareservasada.domain.dto.MovieDTO;
import org.adaschool.sistemareservasada.domain.entity.Movie;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api/v1/movie")
public record MovieController(MovieService movieService) {
    @PostMapping
    public ResponseEntity<?> registerMovie(@RequestBody MovieDTO movieDTO) {
        movieService.createMovie(movieDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // Devuelve todas las peliculas
    @GetMapping
    public ResponseEntity<List<Movie>> getAllMovies() {
        List<Movie> movies = movieService.getAllMovies();
        return new ResponseEntity<>(movies, HttpStatus.FOUND);
    }

    //Devuelve una pelicula acorde a su ID
    @GetMapping("/{movieId}")
    public ResponseEntity<Movie> getMovieById(@PathVariable Integer movieId) {
        Movie movie = movieService.getMovieById(movieId);
        return new ResponseEntity<>(movie, HttpStatus.OK);
    }

    //Modifica una pelicula
    @PutMapping("/{movieId}")
    public ResponseEntity<?> updateMovie(@PathVariable Integer movieId, @RequestBody MovieDTO movieDTO) {
        movieService.updateMovie(movieId, movieDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{movieId}")
    public ResponseEntity<?> deleteMovie(@PathVariable Integer movieId) {
        movieService.deleteMovie(movieId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

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
public record MovieController(
        MovieService movieService
) {
    @PostMapping
    public ResponseEntity<?> registerMovie(@RequestBody MovieDTO movieDTO) {
        movieService.createMovie(movieDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // Devuelve todas las peliculas
    @GetMapping
    public ResponseEntity<List<MovieDTO>> getAllMovies() {
        List<MovieDTO> movies = movieService.getAllMovies();
        return new ResponseEntity<>(movies, HttpStatus.FOUND);
    }

    //Modifica una pelicula
    @PutMapping("/{movieId}")
    public ResponseEntity<?> updateMovie(@PathVariable("movieId") Integer movieId, @RequestBody MovieDTO movieDTO) throws Exception {
        movieService.updateMovie(movieId, movieDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{movieId}")
    public ResponseEntity<?> deleteMovie(@PathVariable Integer movieId) {
        movieService.deleteMovie(movieId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

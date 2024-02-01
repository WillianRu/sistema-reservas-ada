package org.adaschool.sistemareservasada.application.controller;

import org.adaschool.sistemareservasada.application.service.MovieService;
import org.adaschool.sistemareservasada.domain.dto.MovieDTO;
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
    public ResponseEntity<List<MovieDTO>> findAllMovies() {
        List<MovieDTO> movies = movieService.findAllMovies();
        return new ResponseEntity<>(movies, HttpStatus.FOUND);
    }

    @GetMapping("/{id}")
    public ResponseEntity <MovieDTO> findMovieById(@PathVariable Integer id) throws Exception{
        MovieDTO movie = movieService.findMovieById(id);
        return new ResponseEntity<>(movie,HttpStatus.OK);
    }

    //Modifica una pelicula
    @PutMapping("/{id}")
    public ResponseEntity<?> updateMovie(@PathVariable Integer id, @RequestBody MovieDTO movieDTO) throws Exception {
        movieService.updateMovie(id, movieDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteMovie(@PathVariable Integer id) throws Exception{
        movieService.deleteMovie(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

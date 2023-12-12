package org.adaschool.sistemareservasada.application.controller;

import org.adaschool.sistemareservasada.application.service.MovieService;
import org.adaschool.sistemareservasada.domain.dto.MovieDTO;
import org.adaschool.sistemareservasada.domain.entity.Movie;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/movie")
public record MovieController(MovieService movieService) {
    @PostMapping
    public ResponseEntity<?> registerMovie(@RequestBody MovieDTO movieDTO){
        movieService.createMovie(movieDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

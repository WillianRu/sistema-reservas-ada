package org.adaschool.sistemareservasada.application.controller;

import org.adaschool.sistemareservasada.application.service.MovieService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/movie")
public record MovieController(MovieService movieService) {
    /*
    Crear un endpoint POST para recibir una entidad Movie
    Return response status | HTTP.Status.CREATED
     */
}

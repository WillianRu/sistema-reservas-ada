package org.adaschool.sistemareservasada.application.service;

import org.adaschool.sistemareservasada.domain.repository.MovieRepository;
import org.springframework.stereotype.Service;

@Service
public record MovieService(MovieRepository movieRepository) {
}

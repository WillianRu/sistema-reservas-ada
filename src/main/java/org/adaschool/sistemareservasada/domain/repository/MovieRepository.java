package org.adaschool.sistemareservasada.domain.repository;

import org.adaschool.sistemareservasada.domain.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository <Movie, Integer> {

    /*
    Consultas JPQL
    Consultas SQL Nativas

    Son consultas un poco mas avanzadas, no se hacen consultas del tipo insert, remove, update y demas
     */
}

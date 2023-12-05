package org.adaschool.sistemareservasada.domain.repository;

import org.adaschool.sistemareservasada.domain.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository <Movie, Integer> {

}

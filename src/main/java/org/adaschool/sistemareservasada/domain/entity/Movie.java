package org.adaschool.sistemareservasada.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Objects;

@Getter
@Setter
@ToString
@AllArgsConstructor

@Entity
@Table(name="movie")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    String name;
    String genero;
    Integer movieLengthMinuts;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return Objects.equals(id, movie.id) && Objects.equals(name, movie.name) && Objects.equals(genero, movie.genero) && Objects.equals(movieLengthMinuts, movie.movieLengthMinuts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, genero, movieLengthMinuts);
    }
}

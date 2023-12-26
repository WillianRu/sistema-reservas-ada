package org.adaschool.sistemareservasada.domain.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Entity
@Table(name="movie")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String movie_name;
    String genre;
    Integer movieLengthMinutes;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return Objects.equals(id, movie.id) && Objects.equals(movie_name, movie.movie_name) && Objects.equals(genre, movie.genre) && Objects.equals(movieLengthMinutes, movie.movieLengthMinutes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, movie_name, genre, movieLengthMinutes);
    }
}

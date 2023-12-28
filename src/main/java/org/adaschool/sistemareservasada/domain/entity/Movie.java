package org.adaschool.sistemareservasada.domain.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
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

    String name;
    String genre;
    Integer movieLengthMinutes;

    //Relaciones muchos a uno
    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL)
    private List<Reservation> reservations;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return Objects.equals(id, movie.id) && Objects.equals(name, movie.name) && Objects.equals(genre, movie.genre) && Objects.equals(movieLengthMinutes, movie.movieLengthMinutes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, genre, movieLengthMinutes);
    }
}

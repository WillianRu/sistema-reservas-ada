package org.adaschool.sistemareservasada.domain.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.Objects;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Entity
@Table(name="reservation")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @ManyToOne
    @JoinColumn(name = "movie_name") // Nombre de la columna que representa la relación con Movie
    String movie_name;

    @ManyToOne
    @JoinColumn(name = "userAccount_name") // Nombre de la columna que representa la relación con UserAccount
    String userAccount_name;

    Date reservationDate;
    Integer seatsNumber;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reservation that = (Reservation) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

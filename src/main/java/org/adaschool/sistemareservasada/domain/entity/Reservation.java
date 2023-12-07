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

    String movieName;
    String userName;
    Date reservationDate;
    Integer seatsNumber;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reservation that = (Reservation) o;
        return Objects.equals(id, that.id) && Objects.equals(movieName, that.movieName) && Objects.equals(userName, that.userName) && Objects.equals(reservationDate, that.reservationDate) && Objects.equals(seatsNumber, that.seatsNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, movieName, userName, reservationDate, seatsNumber);
    }
}

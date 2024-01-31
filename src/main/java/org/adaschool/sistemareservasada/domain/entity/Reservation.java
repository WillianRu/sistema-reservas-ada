package org.adaschool.sistemareservasada.domain.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Data

@Entity
@Table(name="reservation")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    //Relacion muchos a uno: Varias peliculas pueden pertenecer a una reserva
    @ManyToOne
    @JoinColumn(name = "movie_id") //
    private Movie movie;

    //Relacion muchos a uno: Varias usuarips pueden pertenecer a una reserva
//    @ManyToOne
//    @JoinColumn(name = "userAccount_id") //
//    private UserAccount userAccount;

    Date reservationDate;
    Integer seatsNumber;

}

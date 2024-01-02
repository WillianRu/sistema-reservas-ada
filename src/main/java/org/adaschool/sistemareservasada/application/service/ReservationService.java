package org.adaschool.sistemareservasada.application.service;

import org.adaschool.sistemareservasada.domain.dto.ReservationDTO;
import org.adaschool.sistemareservasada.domain.entity.Movie;
import org.adaschool.sistemareservasada.domain.entity.Reservation;
import org.adaschool.sistemareservasada.domain.entity.UserAccount;

import org.adaschool.sistemareservasada.domain.repository.MovieRepository;
import org.adaschool.sistemareservasada.domain.repository.ReservationRepository;
import org.adaschool.sistemareservasada.domain.repository.UserAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ReservationService {

    private final ReservationRepository reservationRepository;
    private final MovieRepository movieRepository;
    private final UserAccountRepository userAccountRepository;

    @Autowired
    public ReservationService(ReservationRepository reservationRepository, MovieRepository movieRepository,
                              UserAccountRepository userAccountRepository) {
        this.reservationRepository = reservationRepository;
        this.movieRepository = movieRepository;
        this.userAccountRepository = userAccountRepository;
    }

    public Reservation createReservation(ReservationDTO reservationDTO) {
        // Obtener la película por su ID
        Movie movie = movieRepository.findById(reservationDTO.getMovieId())
                .orElseThrow(() -> new IllegalArgumentException("Película no encontrada"));

        // Obtener la cuenta de usuario por su ID
        UserAccount userAccount = userAccountRepository.findById(reservationDTO.getUserAccountId())
                .orElseThrow(() -> new IllegalArgumentException("Cuenta de usuario no encontrada"));

        // Crear una nueva reserva con los datos proporcionados
        Reservation newReservation = new Reservation();

        newReservation.setMovie(movie);
        newReservation.setUserAccount(userAccount);
        newReservation.setReservationDate(new Date()); // Establecer la fecha actual como fecha de reserva
        newReservation.setSeatsNumber(reservationDTO.getSeatsNumber()); // Establecer el número de asientos

        // Guardar la nueva reserva en el repositorio y devolverla
        return reservationRepository.save(newReservation);
    }
}

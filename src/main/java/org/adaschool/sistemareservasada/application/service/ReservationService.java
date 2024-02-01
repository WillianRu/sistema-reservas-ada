package org.adaschool.sistemareservasada.application.service;

import org.adaschool.sistemareservasada.application.mapper.ReservationMapper;
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
import java.util.List;

@Service
public record ReservationService(
        ReservationRepository reservationRepository,
        ReservationMapper mapper,
        MovieRepository movieRepository,
        UserAccountRepository userAccountRepository
) {



    public void createReservation(ReservationDTO reservationDTO) {
        // Obtener la película y la cuenta de usuario usando los ID proporcionados
        Movie movie = movieRepository.findById(reservationDTO.movieId())
                .orElseThrow(() -> new IllegalArgumentException("Película no encontrada con ID: " + reservationDTO.movieId()));

        UserAccount userAccount = userAccountRepository.findById(reservationDTO.userAccountId())
                .orElseThrow(() -> new IllegalArgumentException("Cuenta de usuario no encontrada con ID: " + reservationDTO.userAccountId()));

        // Mapear el DTO a la entidad Reservation
        Reservation reservation = mapper.toEntity(reservationDTO);

        // Asignar la película y la cuenta de usuario a la reserva
        reservation.setMovie(movie);
        reservation.setUserAccount(userAccount);

        // Si la fecha de reserva es proporcionada, usarla, de lo contrario, usar la fecha actual
        reservation.setReservationDate(reservationDTO.reservationDate() != null ? reservationDTO.reservationDate() : new Date());

        // Guardar la reserva
        reservationRepository.save(reservation);
    }

    public List<ReservationDTO> findAllReservations(){
        List<Reservation> reservations = reservationRepository.findAll();
        return mapper.toDtoList(reservations);
    }
}

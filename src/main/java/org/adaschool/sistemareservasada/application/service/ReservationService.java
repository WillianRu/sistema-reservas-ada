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
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

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
        Movie movie = movieRepository.findById(reservationDTO.movieId())
                .orElseThrow(() -> new IllegalArgumentException("Película no encontrada con ID: " + reservationDTO.movieId()));

        UserAccount userAccount = userAccountRepository.findById(reservationDTO.userAccountId())
                .orElseThrow(() -> new IllegalArgumentException("Cuenta de usuario no encontrada con ID: " + reservationDTO.userAccountId()));

        Reservation reservation = mapper.toEntity(reservationDTO);

        reservation.setMovie(movie);
        reservation.setUserAccount(userAccount);

        reservation.setReservationDate(reservationDTO.reservationDate() != null ? reservationDTO.reservationDate() : new Date());

        reservationRepository.save(reservation);
    }

    public List<ReservationDTO> findAllReservations(){
        List<Reservation> reservations = reservationRepository.findAll();
        return mapper.toDtoList(reservations);
    }

    public void editReservation(Integer id, ReservationDTO reservationDTO) throws Exception{
        Reservation reservation = reservationRepository.findById(id)
                .orElseThrow(() -> new Exception("Reservation not found"));

        Movie movie = movieRepository.findById(reservationDTO.movieId())
                .orElseThrow(() -> new IllegalArgumentException("Película no encontrada con ID: " + reservationDTO.movieId()));

        UserAccount userAccount = userAccountRepository.findById(reservationDTO.userAccountId())
                .orElseThrow(() -> new IllegalArgumentException("Cuenta de usuario no encontrada con ID: " + reservationDTO.userAccountId()));

        // Actualizar los campos de la entidad existente con los valores del DTO
        reservation.setId(id);
        reservation.setMovie(movie);
        reservation.setUserAccount(userAccount);
        reservation.setReservationDate(reservationDTO.reservationDate() != null ? reservationDTO.reservationDate() : new Date());

        reservationRepository.save(reservation);
    }

    public void deleteReservation(Integer id) throws Exception{
        Reservation reservation = reservationRepository.findById(id)
                .orElseThrow(() -> new Exception("Reservation not found"));
        reservationRepository.delete(reservation);
    }


}

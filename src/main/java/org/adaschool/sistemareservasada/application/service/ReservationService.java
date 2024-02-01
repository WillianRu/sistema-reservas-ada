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
        // Obtener la película por su ID
        Movie movie = movieRepository.findById(reservationDTO.getMovieId())
                .orElseThrow(() -> new IllegalArgumentException("Película no encontrada"));

        // Obtener la cuenta de usuario por su ID
        UserAccount userAccount = userAccountRepository.findById(reservationDTO.getUserAccountId())
                .orElseThrow(() -> new IllegalArgumentException("Cuenta de usuario no encontrada"));

        // Convertir ReservationDTO a Reservation usando el mapper
        Reservation newReservation = mapper.toEntity(reservationDTO);

        // Establecer la película y la cuenta de usuario en la reserva, ya que no están incluidos en el DTO
        newReservation.setMovie(movie);
        newReservation.setUserAccount(userAccount);

        // Establecer la fecha actual como fecha de reserva
        newReservation.setReservationDate(new Date());

        // Guardar la nueva reserva en el repositorio y devolverla
        reservationRepository.save(newReservation);
    }

    public List<ReservationDTO> findAllReservations(){
        List<Reservation> reservations = reservationRepository.findAll();
        return mapper.toDtoList(reservations);
    }
}

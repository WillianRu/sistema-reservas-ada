package org.adaschool.sistemareservasada.application.service;

import org.adaschool.sistemareservasada.domain.dto.ReservationDTO;
import org.adaschool.sistemareservasada.domain.entity.Reservation;
import org.adaschool.sistemareservasada.domain.repository.ReservationRepository;
import org.springframework.stereotype.Service;

@Service
public record ReservationService(ReservationRepository reservationRepository) {

    public void createReservation(ReservationDTO reservationDTO){
        Reservation reservation = Reservation.builder()
                .movieName(reservationDTO.movieName())
                .userName(reservationDTO.userName())
                .reservationDate(reservationDTO.reservationDate())
                .seatsNumber(reservationDTO.seatsNumber())
                .build();
        reservationRepository.save(reservation);

    }
}

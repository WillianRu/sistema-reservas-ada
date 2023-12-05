package org.adaschool.sistemareservasada.application.service;

import org.adaschool.sistemareservasada.domain.repository.ReservationRepository;
import org.springframework.stereotype.Service;

@Service
public record ReservationService(ReservationRepository reservationRepository) {
}

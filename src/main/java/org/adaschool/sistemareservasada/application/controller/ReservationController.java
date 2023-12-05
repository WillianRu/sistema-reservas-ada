package org.adaschool.sistemareservasada.application.controller;

import org.adaschool.sistemareservasada.application.service.ReservationService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/reservation")
public record ReservationController(ReservationService reservationService) {
}

package org.adaschool.sistemareservasada.application.controller;

import org.adaschool.sistemareservasada.application.service.ReservationService;
import org.adaschool.sistemareservasada.domain.dto.ReservationDTO;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/reservation")
public record ReservationController(ReservationService reservationService) {
    @PostMapping
    public ResponseEntity<?> registerReservation(@RequestBody ReservationDTO reservationDTO){
        reservationService.createReservation(reservationDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

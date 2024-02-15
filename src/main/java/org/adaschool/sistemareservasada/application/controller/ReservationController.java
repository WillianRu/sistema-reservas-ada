package org.adaschool.sistemareservasada.application.controller;

import org.adaschool.sistemareservasada.application.service.ReservationService;
import org.adaschool.sistemareservasada.domain.dto.ReservationDTO;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/reservation")
public record ReservationController(ReservationService reservationService) {
    @PostMapping
    public ResponseEntity<?> registerReservation(@RequestBody ReservationDTO reservationDTO){
        reservationService.createReservation(reservationDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<?> findAllReservations(){
        List<ReservationDTO> reservations = reservationService.findAllReservations();
        return new ResponseEntity<>(reservations, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteReservation(@PathVariable Integer id) throws Exception{
        reservationService.deleteReservation(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> editReservation(@PathVariable("id") Integer id, @RequestBody ReservationDTO reservationDTO) throws Exception{
        reservationService.editReservation(id, reservationDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

package org.adaschool.sistemareservasada.domain.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Date;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record ReservationDTO(
        String movieName,
        String userName,
        Date reservationDate,
        Integer seatsNumber
) {
}

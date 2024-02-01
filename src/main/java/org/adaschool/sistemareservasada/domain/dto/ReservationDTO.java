package org.adaschool.sistemareservasada.domain.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.Date;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record ReservationDTO(
        Integer id,
        Integer movieId,
        MovieDTO movie,
        UserAccountDTO userAccount,
        Integer userAccountId,
        Date reservationDate,
        Integer seatsNumber
) {
}

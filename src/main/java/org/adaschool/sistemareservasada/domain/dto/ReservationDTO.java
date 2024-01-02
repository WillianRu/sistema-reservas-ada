package org.adaschool.sistemareservasada.domain.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.Date;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record ReservationDTO(
        Integer movieId,
        Integer userAccountId,
        Date reservationDate,
        Integer seatsNumber
) {
    public Integer getMovieId() {
        return this.movieId;
    }

    public Integer getUserAccountId() {
        return this.userAccountId;
    }

    public Integer getSeatsNumber() {
        return this.seatsNumber;
    }
}

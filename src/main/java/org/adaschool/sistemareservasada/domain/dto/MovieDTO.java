package org.adaschool.sistemareservasada.domain.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

//@JsonInclude(JsonInclude.Include.NON_NULL)
public record MovieDTO(
        Integer id,
        String name,
        String genre,
        Integer movieLengthMinutes
) {}

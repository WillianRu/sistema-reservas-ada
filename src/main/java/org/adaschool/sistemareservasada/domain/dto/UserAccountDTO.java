package org.adaschool.sistemareservasada.domain.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record UserAccountDTO(
    String name,
    Integer phoneNumber,
    String email
) {}

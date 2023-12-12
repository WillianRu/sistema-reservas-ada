package org.adaschool.sistemareservasada.domain.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.adaschool.sistemareservasada.application.lasting.ERole;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record UserAccountDTO(
    String name,
    Integer phoneNumber,
    String email,
    String password,
    Boolean enable,
    ERole erole
) {}

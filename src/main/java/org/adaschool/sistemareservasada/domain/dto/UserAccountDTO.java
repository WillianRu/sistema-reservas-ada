package org.adaschool.sistemareservasada.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.adaschool.sistemareservasada.application.lasting.ERole;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record UserAccountDTO(
        Integer id,
        String name,
        Integer phoneNumber,
        String email,
        @JsonIgnore(value=false)
        String password,
        Boolean enable,
        ERole erole
) {}

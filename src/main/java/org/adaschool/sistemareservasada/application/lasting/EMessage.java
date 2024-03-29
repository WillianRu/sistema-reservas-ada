package org.adaschool.sistemareservasada.application.lasting;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum EMessage {

    DATA_NOT_FOUND(HttpStatus.NOT_FOUND, "The data was not found"),
    USER_NOT_FOUND(HttpStatus.NOT_FOUND, "The User was not found"),
    UNAUTHORIZED(HttpStatus.UNAUTHORIZED, "The user was not Authorized to access at the application");

    private final HttpStatus statusCode;
    private final String message;


}
package org.adaschool.sistemareservasada.application.controller;

import lombok.RequiredArgsConstructor;
import org.adaschool.sistemareservasada.application.service.AuthenticationService;
import org.adaschool.sistemareservasada.domain.dto.AuthenticationDTO;
import org.adaschool.sistemareservasada.domain.dto.UserAccountDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
public record AuthenticationController(AuthenticationService authenticationService) {
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody UserAccountDTO userAccountDTO){
        String token = authenticationService.register(userAccountDTO);
        return new ResponseEntity<>(token, HttpStatus.CREATED);
    }

    @PostMapping("/authenticate")
    public ResponseEntity<?> authenticate(@RequestBody AuthenticationDTO authenticationDTO){
        String token = authenticationService.authenticate(authenticationDTO);
        return new ResponseEntity<>(token, HttpStatus.OK);
    }
}

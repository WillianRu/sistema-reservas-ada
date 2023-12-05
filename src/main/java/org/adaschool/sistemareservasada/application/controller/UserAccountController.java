package org.adaschool.sistemareservasada.application.controller;

import org.adaschool.sistemareservasada.application.service.UserAccountService;
import org.adaschool.sistemareservasada.domain.dto.MovieDTO;
import org.adaschool.sistemareservasada.domain.dto.UserAccountDTO;
import org.apache.catalina.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/user")
public record UserAccountController(UserAccountService userAccountService) {
    @PostMapping
    public ResponseEntity<?> registerUserAccount(@RequestBody UserAccountDTO userAccountDTO){
        userAccountService.createUserAccount(userAccountDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

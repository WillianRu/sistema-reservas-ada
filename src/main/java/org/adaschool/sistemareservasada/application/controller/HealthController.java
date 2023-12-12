package org.adaschool.sistemareservasada.application.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth/health")
public record HealthController() {

    @GetMapping
    public ResponseEntity<?> healthApi(){
        return new ResponseEntity<>("API working OK!", HttpStatus.OK);
    }
}

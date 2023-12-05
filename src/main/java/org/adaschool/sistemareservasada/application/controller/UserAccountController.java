package org.adaschool.sistemareservasada.application.controller;

import org.adaschool.sistemareservasada.application.service.UserAccountService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/user")
public record UserAccountController(UserAccountService userService) {
}

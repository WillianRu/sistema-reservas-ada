package org.adaschool.sistemareservasada.application.service;

import org.adaschool.sistemareservasada.domain.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public record UserAccountService(UserRepository userRepository) {
}

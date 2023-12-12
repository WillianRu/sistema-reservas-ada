package org.adaschool.sistemareservasada.application.service;

import org.adaschool.sistemareservasada.application.lasting.ERole;
import org.adaschool.sistemareservasada.domain.dto.AuthenticationDTO;
import org.adaschool.sistemareservasada.domain.dto.UserAccountDTO;
import org.adaschool.sistemareservasada.domain.entity.UserAccount;
import org.adaschool.sistemareservasada.domain.repository.UserAccountRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public record AuthenticationService(UserAccountRepository userAccountRepository, JwtService jwtService, PasswordEncoder passwordEncoder, AuthenticationManager authenticationManager) {
    public String register(UserAccountDTO userAccountDTO) {
        UserAccount userAccount = UserAccount.builder()
                .name(userAccountDTO.name())
                .phoneNumber(userAccountDTO.phoneNumber())
                .email(userAccountDTO.email())
                .password(passwordEncoder.encode(userAccountDTO.password()))
                .role(ERole.USER)
                .enable(true)
                .build();
        userAccountRepository.save(userAccount);
        return jwtService.generateToken(userAccount);
    }

    public String authenticate(AuthenticationDTO authenticationDTO){
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                authenticationDTO.email(),
                authenticationDTO.password()
        ));
        UserAccount userAccount = userAccountRepository.findUserByEmail(authenticationDTO.email())
                .orElseThrow();
        return jwtService.generateToken(userAccount);
    }
}

package org.adaschool.sistemareservasada.application.config;

import lombok.RequiredArgsConstructor;
import org.adaschool.sistemareservasada.application.lasting.EMessage;
import org.adaschool.sistemareservasada.domain.repository.UserAccountRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@RequiredArgsConstructor
@Configuration

public class ApplicationConfig {
    private final UserAccountRepository userAccountRepository;
    @Bean
    public UserDetailsService userDetailsService (){
        return username -> userAccountRepository.findUserByEmail(username)
                .orElseThrow(()-> new UsernameNotFoundException(EMessage.USER_NOT_FOUND.getMessage()));
    }
    @Bean
    public AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService());
        authenticationProvider.setPasswordEncoder(passwordEnconder());
        return authenticationProvider;
    }

    @Bean
    public PasswordEncoder passwordEnconder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }

}

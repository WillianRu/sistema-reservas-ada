package org.adaschool.sistemareservasada.application.service;

import org.adaschool.sistemareservasada.domain.dto.UserAccountDTO;
import org.adaschool.sistemareservasada.domain.entity.UserAccount;
import org.adaschool.sistemareservasada.domain.repository.UserAccountRepository;
import org.springframework.stereotype.Service;

@Service
public record UserAccountService(UserAccountRepository userAccountRepository) {
    public void createUserAccount(UserAccountDTO userAccountDTO){
        UserAccount userAccount = UserAccount.builder()
                .name(userAccountDTO.name())
                .phoneNumber(userAccountDTO.phoneNumber())
                .email(userAccountDTO.email())
                .password(userAccountDTO.password())
                .enable(userAccountDTO.enable())
                .build();
        userAccountRepository.save(userAccount);
    }
}

package org.adaschool.sistemareservasada.domain.repository;

import org.adaschool.sistemareservasada.domain.entity.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserAccountRepository extends JpaRepository<UserAccount, Integer> {
    Optional<UserAccount> findUserByEmail(String email);
}

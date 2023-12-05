package org.adaschool.sistemareservasada.domain.repository;

import org.adaschool.sistemareservasada.domain.entity.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserAccountRepository extends JpaRepository<UserAccount, Integer> {
     /*
    Consultas JPQL
    Consultas SQL Nativas

    Son consultas un poco mas avanzadas, no se hacen consultas del tipo insert, remove, update y demas
     */
}

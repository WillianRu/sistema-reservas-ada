package org.adaschool.sistemareservasada.domain.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;

@Entity
@Table(name="userAccount")

@Getter
@Setter
@ToString
@AllArgsConstructor
@Builder

public class UserAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    String name;
    Integer phoneNumber;
    String email;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserAccount user = (UserAccount) o;
        return Objects.equals(id, user.id) && Objects.equals(name, user.name) && Objects.equals(phoneNumber, user.phoneNumber) && Objects.equals(email, user.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, phoneNumber, email);
    }
}



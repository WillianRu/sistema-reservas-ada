package org.adaschool.sistemareservasada.domain.entity;

import jakarta.persistence.*;
import lombok.*;
import org.adaschool.sistemareservasada.application.lasting.ERole;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.Objects;



@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Entity
@Table(name="userAccount", uniqueConstraints = {@UniqueConstraint(columnNames = {"email"})})
public class UserAccount implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    String name;
    Integer phoneNumber;
    String email;
    String password;
    Boolean enable;

    //Relacion uno a muchos: Una usuario puede tener muchas reservas
    @OneToMany(mappedBy = "userAccount", cascade = CascadeType.ALL)
    private List<Reservation> reservations;


    @Enumerated(EnumType.ORDINAL)
    private ERole role;

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

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return this.enable;
    }
}



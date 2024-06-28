package com.vtes.backend_vtes.Entities;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.vtes.backend_vtes.Entities.enums.Role;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user", uniqueConstraints = {
    @UniqueConstraint(columnNames = "email"),
    @UniqueConstraint(columnNames = "username")
})
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer userId;

    @Enumerated(EnumType.STRING)
    Role role;

    @NotBlank(message = "El nombre es Obligatorio")
    @Column(nullable = false)
    private String username;

    @NotBlank(message = "El apellido es Obligatorio")
    private String lastname;

    @NotNull(message = "La fecha de nacimiento es obligatoria")
    @Temporal(TemporalType.DATE)
    private Date birthdate;

    @NotBlank(message = "El país es obligatorio")
    private String country;

    @NotBlank(message = "La ciudad es obligatoria")
    private String city;

    @NotBlank(message = "La dirección es obligatoria")
    private String address;

    @NotBlank(message = "El número de teléfono es obligatorio")
    private String phone;

    @NotBlank(message = "El estado de la cuenta es obligatorio")
    private String stateAccount;

    @NotBlank(message = "Añade un Nick")
    private String nick;

    @NotBlank(message = "Añade un Email Valido")
    @Email(message = "El Email no es valido")
    private String email;

    private String avatarUrl;

    @NotBlank(message = "La contraseña es obligatoria")
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{5,}$", message = "La contraseña debe tener al menos 5 caracteres, una mayúscula y un número")
    private String password;



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
        return true;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    
}

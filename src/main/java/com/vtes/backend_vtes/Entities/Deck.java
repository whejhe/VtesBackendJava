package com.vtes.backend_vtes.Entities;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "deck")
public class Deck implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY, generator="deck_sequence")
    @SequenceGenerator(name="deck_sequence", sequenceName="deck_sequence", allocationSize=100)
    private Integer deck_id;

    @NotNull(message = "El ID de usuario es obligatorio")
    private Integer user_id;

    @NotBlank(message = "El nombre del mazo es obligatorio")
    private String deck_name;

    private String description;

    @NotBlank(message = "El autor es obligatorio")
    private String author;

    @NotBlank(message = "La categoría es obligatoria")
    private String category;

    private Boolean is_public;

    @ManyToOne
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    private User user;
}

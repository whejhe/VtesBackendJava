package com.vtes.backend_vtes.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "customCard")
public class CustomCard {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer customCardId;

    private Integer userId;

    @NotBlank(message = "El nombre de la carta personalizada es obligatorio")
    private String customCardName;

    @NotBlank(message = "El autor es obligatorio")
    private String author;

    private Integer capacity;

    @NotBlank(message = "La URL de la carta personalizada es obligatoria")
    private String customCardUrl;

    private String clan;

    private String disciplines;

    private Integer groupVampire;

    @NotBlank(message = "El tipo de carta personalizada es obligatorio")
    private String customCardType;

    private String logoColor;

    @NotBlank(message = "El texto de la carta personalizada es obligatorio")
    private String customCardText;

    private Boolean isPublic;

    private Integer costPool;

    private Integer costBlood;

    @ManyToOne
    @JoinColumn(name = "userId", insertable = false, updatable = false)
    private User user;
}

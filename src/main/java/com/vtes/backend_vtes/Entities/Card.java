package com.vtes.backend_vtes.Entities;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "card")
public class Card implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer cardId;

    @NotBlank(message = "El nombre de la carta es obligatorio")
    private String cardName;

    @NotBlank(message = "La URL de la carta es obligatoria")
    private String cardUrl;

    @NotBlank(message = "El tipo de carta es obligatorio")
    private String cardType;

    @NotBlank(message = "El texto de la carta es obligatorio")
    private String cardText;

    private String orderedSets;

    private String title;

    private String clan;

    private Boolean multidiscipline;

    private String disciplines;

    private Integer capacity;

    private Integer costPool;

    private Integer costBlood;

    private String rulings;

    private String sets;

    private Integer groups;
}

package com.vtes.backend_vtes.Entities;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
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
    @GeneratedValue(strategy=GenerationType.IDENTITY, generator="card_sequence")
    @SequenceGenerator(name="card_sequence", sequenceName="card_sequence", allocationSize=100)
    private Integer card_id;

    @NotBlank(message = "El nombre de la carta es obligatorio")
    private String card_name;

    @NotBlank(message = "La URL de la carta es obligatoria")
    private String card_url;

    @NotBlank(message = "El tipo de carta es obligatorio")
    private String card_type;

    @NotBlank(message = "El texto de la carta es obligatorio")
    private String card_text;

    private String ordered_sets;

    private String title;

    private String clan;

    private Boolean multidiscipline;

    private String disciplines;

    private Integer capacity;

    private Integer cost_pool;

    private Integer cost_blood;

    private String rulings;

    private String sets;

    private Integer groups;
}

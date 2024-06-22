package com.vtes.backend_vtes.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name = "custom_card")
public class CustomCard {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY, generator="custom_card_sequence")
    @SequenceGenerator(name="custom_card_sequence", sequenceName="custom_card_sequence", allocationSize=100)
    private Integer custom_card_id;

    private Integer user_id;

    @NotBlank(message = "El nombre de la carta personalizada es obligatorio")
    private String custom_card_name;

    @NotBlank(message = "El autor es obligatorio")
    private String author;

    private Integer capacity;

    @NotBlank(message = "La URL de la carta personalizada es obligatoria")
    private String custom_card_url;

    private String clan;

    private String disciplines;

    private Integer group_vampire;

    @NotBlank(message = "El tipo de carta personalizada es obligatorio")
    private String custom_card_type;

    private String logo_color;

    @NotBlank(message = "El texto de la carta personalizada es obligatorio")
    private String custom_card_text;

    private Boolean is_public;

    private Integer cost_pool;

    private Integer cost_blood;

    @ManyToOne
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    private User user;
}

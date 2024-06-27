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
@Table(name = "report")
public class Report {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer reportId;

    private Integer userId;

    private Integer cardId;

    @NotBlank(message = "El nombre de la carta es obligatorio")
    private String cardName;

    @NotBlank(message = "El autor de la carta es obligatorio")
    private String cardAuthor;

    @NotBlank(message = "El email del reportero es obligatorio")
    private String emailReporter;

    @NotBlank(message = "El nombre del usuario reportero es obligatorio")
    private String nameUserReporter;

    @NotBlank(message = "La razón es obligatoria")
    private String reason;

    private String comment;

    private Boolean isChecked;

    @ManyToOne
    @JoinColumn(name = "userId", insertable = false, updatable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "cardId", insertable = false, updatable = false)
    private Card card;
}

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
@Table(name = "report")
public class Report {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY, generator="report_sequence")
    @SequenceGenerator(name="report_sequence", sequenceName="report_sequence", allocationSize=100)
    private Integer report_id;

    private Integer user_id;

    private Integer card_id;

    @NotBlank(message = "El nombre de la carta es obligatorio")
    private String card_name;

    @NotBlank(message = "El autor de la carta es obligatorio")
    private String card_author;

    @NotBlank(message = "El email del reportero es obligatorio")
    private String email_reporter;

    @NotBlank(message = "El nombre del usuario reportero es obligatorio")
    private String name_user_reporter;

    @NotBlank(message = "La razón es obligatoria")
    private String reason;

    private String comment;

    private Boolean is_checked;

    @ManyToOne
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "card_id", insertable = false, updatable = false)
    private Card card;
}

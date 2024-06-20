package com.proyect.vtes.Entities;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "report")
public class report implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="report_sequence")
    @SequenceGenerator(name="report_sequence", sequenceName="report_sequence", allocationSize=100)
    private Integer reportId;
    private Integer userId;
    private Integer authorOfCard;
    private Integer customCardId;
    private String cardName;
    private String email;
    private boolean isView;
    private String comment;
}
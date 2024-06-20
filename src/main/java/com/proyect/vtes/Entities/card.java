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
@Table(name = "card")
public class card implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="card_sequence")
    @SequenceGenerator(name="card_sequence", sequenceName="card_sequence", allocationSize=100)
    private Integer cardId;
    private Integer userId;
    private String cardName;
    private String cardUrl;
    private String cardType;
    private String title;
    private String clan;
    private Integer capacity;
    private String disciplineName;
    private boolean multidiscipline;
    private String cardText;
    private String orderedSets;
    private int boodCost;
    private int poolCost;
    private String rulingsText;
    private String sets;
    private int grupVampire;
    
}
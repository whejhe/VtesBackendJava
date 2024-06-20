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
@Table(name = "deck")
public class deck implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="deck_sequence")
    @SequenceGenerator(name="deck_sequence", sequenceName="deck_sequence", allocationSize=100)
    private Integer deckId;
    private Integer userId;
    private String deckName;
    private String description;
    private String author;
    private String category;
    private boolean isPublic;
    
}
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
@Table(name = "library")
public class library implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="library_sequence")
    @SequenceGenerator(name="library_sequence", sequenceName="library_sequence", allocationSize=100)
    private Integer deckId;
    private Integer cardId;
    private Integer quantity;
    
}
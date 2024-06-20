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
@Table(name = "crypt")
public class crypt implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="crypt_sequence")
    @SequenceGenerator(name="crypt_sequence", sequenceName="crypt_sequence", allocationSize=100)
    private Integer deckId;
    private Integer cardId;
    private Integer quantity;
}
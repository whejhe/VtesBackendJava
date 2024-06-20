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
@Table(name = "customcard")
public class customCard implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="customcard_sequence")
    @SequenceGenerator(name="customcard_sequence", sequenceName="customcard_sequence", allocationSize=100)
    private Integer customCardId;
    private Integer userId;
    private String customCardName;
    private String author;
    private Integer capacity;
    private String customCardImage;
    private String clan;
    private String discipline;
    private Integer groupVampire;
    private String customCardType;
    private String logoColor;
    private String description;
    private boolean isPublic;
    private Integer costBlood;
    private Integer costPool;
    private String customCardUrl;
    
}
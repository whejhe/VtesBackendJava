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
@Table(name = "avatar")
public class avatar implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="avatar_sequence")
    @SequenceGenerator(name="avatar_sequence", sequenceName="avatar_sequence", allocationSize=100)
    private Integer avatarId;
    private Integer userId;
    private String avatarName;
    private String avatarUrl;
    private String extension;
    
}
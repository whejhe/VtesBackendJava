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
@Table(name = "eventusers")
public class eventUsers implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="eventusers_sequence")
    @SequenceGenerator(name="eventusers_sequence", sequenceName="eventusers_sequence", allocationSize=100)
    private Integer eventId;
    private Integer userId;
}
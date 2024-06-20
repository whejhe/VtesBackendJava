package com.proyect.vtes.Entities;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "event")
public class event implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="event_sequence")
    @SequenceGenerator(name="event_sequence", sequenceName="event_sequence", allocationSize=100)
    private Integer eventId;
    private Integer userId;
    private String eventName;
    private String email;
    private String eventType;
    private double price;
    private String province;
    private String location;
    private String address;
    private String description;
    private Date date;
    private boolean isStarted;
    private Integer numMaxParticipants;
    private Integer registeredParticipants;
    
}
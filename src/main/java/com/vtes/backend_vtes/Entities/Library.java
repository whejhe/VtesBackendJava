package com.vtes.backend_vtes.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "library")
public class Library {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer libraryId;

    private Integer userId;

    private Integer deckId;

    private Integer cardId;

    @ManyToOne
    @JoinColumn(name = "userId", insertable = false, updatable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "deckId", insertable = false, updatable = false)
    private Deck deck;

    @ManyToOne
    @JoinColumn(name = "cardId", insertable = false, updatable = false)
    private Card card;
}

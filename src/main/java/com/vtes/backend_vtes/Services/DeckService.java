package com.vtes.backend_vtes.Services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.vtes.backend_vtes.Entities.Deck;
import com.vtes.backend_vtes.Repositories.DeckRepository;

@Service
public class DeckService {
    @Autowired
    private DeckRepository deckRepository;

    // GETTERS
    public List<Deck> getAllDecks() {
        return deckRepository.findAll();
    }

    public Optional<Deck> getDeckById(Integer id) {
        return deckRepository.findById(id);
    }

    public Deck getDeckByDeckName(String deckName) {
        return deckRepository.findByDeck_name(deckName);
    }

    public List<Deck> getDecksByAuthor(String author) {
        return deckRepository.findByAuthor(author);
    }

    public List<Deck> getDecksByCategory(String category) {
        return deckRepository.findByCategory(category);
    }

    // SAVE
    public Deck saveDeck(Deck deck) {
        return deckRepository.save(deck);
    }

    // UPDATE
    public Deck updateDeck(Deck deck) {
        Optional<Deck> existingDeck = deckRepository.findById(deck.getDeck_id());
        if (existingDeck.isPresent()) {
            Deck updatedDeck = existingDeck.get();
            updatedDeck.setUser_id(deck.getUser_id());
            updatedDeck.setDeck_name(deck.getDeck_name());
            updatedDeck.setDescription(deck.getDescription());
            updatedDeck.setAuthor(deck.getAuthor());
            updatedDeck.setCategory(deck.getCategory());
            updatedDeck.setIs_public(deck.getIs_public());
            return deckRepository.save(updatedDeck);
        } else {
            throw new RuntimeException("Deck not found with id: " + deck.getDeck_id());
        }
    }

    // DELETE
    public void deleteDeck(Integer id) {
        deckRepository.deleteById(id);
    }

    // DELETE BY NAME
    public void deleteDeckByName(String deckName) {
        deckRepository.findByDeck_name(deckName);
    }

    // DELETE BY AUTHOR
    public void deleteDeckByAuthor(String author) {
        deckRepository.findByAuthor(author);
    }
}

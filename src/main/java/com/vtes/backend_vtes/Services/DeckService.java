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
        try{
            return deckRepository.findAll();
        }catch(Exception e){
            throw new RuntimeException("Error al obtener todas las cartas: " + e.getMessage());
        }
    }

    public Optional<Deck> getDeckById(Integer id) {
        try{
            return deckRepository.findById(id);
        }catch(Exception e){
            throw new RuntimeException("Error al obtener la carta con ID " + id + ": " + e.getMessage());
        }
    }

    public Deck getDeckByDeckName(String deckName) {
        try{
            return deckRepository.findByDeck_name(deckName);
        }catch(Exception e){
            throw new RuntimeException("Error al obtener la carta con nombre " + deckName + ": " + e.getMessage());
        }
    }

    public List<Deck> getDecksByAuthor(String author) {
        try{
            return deckRepository.findByAuthor(author);
        }catch(Exception e){
            throw new RuntimeException("Error al obtener las cartas del autor " + author + ": " + e.getMessage());
        }
    }

    public List<Deck> getDecksByCategory(String category) {
        try{
            return deckRepository.findByCategory(category);
        }catch(Exception e){
            throw new RuntimeException("Error al obtener las cartas del autor " + category + ": " + e.getMessage());
        }
    }

    // SAVE
    public Deck saveDeck(Deck deck) {
        try{
            return deckRepository.save(deck);
        }catch(Exception e){
            throw new RuntimeException("Error al guardar la carta: " + e.getMessage());
        }
    }

    // UPDATE
    public Deck updateDeck(Deck deck) {
        try{
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
        }catch(Exception e){
            throw new RuntimeException("Error al actualizar la carta: " + e.getMessage());
        }
    }

    // DELETE
    public void deleteDeck(Integer id) {
        try{
            deckRepository.deleteById(id);
        }catch(Exception e){
            throw new RuntimeException("Error al borrar la carta: " + e.getMessage());
        }
    }

    // DELETE BY NAME
    public void deleteDeckByName(String deckName) {
        try{
            deckRepository.findByDeck_name(deckName);
        }catch(Exception e){
            throw new RuntimeException("Error al borrar la carta: " + e.getMessage());
        }
    }

    // DELETE BY AUTHOR
    public void deleteDeckByAuthor(String author) {
        try{
            deckRepository.findByAuthor(author);
        }catch(Exception e){
            throw new RuntimeException("Error al borrar la carta: " + e.getMessage());
        }
    }
}

package com.vtes.backend_vtes.Controllers;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.vtes.backend_vtes.Entities.Deck;
import com.vtes.backend_vtes.Services.DeckService;

@RestController
@RequestMapping("/decks")
public class DeckController {
    @Autowired
    private DeckService deckService;

    @GetMapping
    public List<Deck> getAllDecks() {
        return deckService.getAllDecks();
    }

    @GetMapping("/{id}")
    public Optional<Deck> getDeckById(@PathVariable Integer id) {
        return deckService.getDeckById(id);
    }

    @GetMapping("/name/{deckName}")
    public Deck getDeckByDeckName(@PathVariable String deckName) {
        return deckService.getDeckByDeckName(deckName);
    }

    @GetMapping("/author/{author}")
    public List<Deck> getDecksByAuthor(@PathVariable String author) {
        return deckService.getDecksByAuthor(author);
    }

    @GetMapping("/category/{category}")
    public List<Deck> getDecksByCategory(@PathVariable String category) {
        return deckService.getDecksByCategory(category);
    }

    @PostMapping
    public Deck saveDeck(@RequestBody Deck deck) {
        return deckService.saveDeck(deck);
    }

    @PutMapping("/{id}")
    public Deck updateDeck(@PathVariable Integer id, @RequestBody Deck deck) {
        deck.setDeck_id(id);
        return deckService.saveDeck(deck);
    }

    @DeleteMapping("/{id}")
    public void deleteDeck(@PathVariable Integer id) {
        deckService.deleteDeck(id);
    }

    @DeleteMapping("/name/{deckName}")
    public void deleteDeckByName(@PathVariable String deckName) {
        deckService.deleteDeckByName(deckName);
    }

    @DeleteMapping("/author/{author}")
    public void deleteDeckByAuthor(@PathVariable String author) {
        deckService.deleteDeckByAuthor(author);
    }
}

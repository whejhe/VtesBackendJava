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
import com.vtes.backend_vtes.Entities.Card;
import com.vtes.backend_vtes.Services.CardService;

@RestController
@RequestMapping("/cards")
public class CardController {
    @Autowired
    private CardService cardService;

    @GetMapping
    public List<Card> getAllCards() {
        return cardService.getAllCards();
    }

    @GetMapping("/{id}")
    public Optional<Card> getCardById(@PathVariable Integer id) {
        return cardService.getCardById(id);
    }

    @GetMapping("/name/{cardName}")
    public Card getCardByCardName(@PathVariable String cardName) {
        return cardService.getCardByCardName(cardName);
    }

    @GetMapping("/type/{cardType}")
    public List<Card> getCardsByCardType(@PathVariable String cardType) {
        return cardService.getCardsByCardType(cardType);
    }

    @GetMapping("/clan/{clan}")
    public List<Card> getCardsByClan(@PathVariable String clan) {
        return cardService.getCardsByClan(clan);
    }

    @PostMapping
    public Card saveCard(@RequestBody Card card) {
        return cardService.saveCard(card);
    }

    @PutMapping("/{id}")
    public Card updateCard(@PathVariable Integer id, @RequestBody Card card) {
        card.setCardId(id);
        return cardService.saveCard(card);
    }

    @DeleteMapping("/{id}")
    public void deleteCard(@PathVariable Integer id) {
        cardService.deleteCard(id);
    }

    @DeleteMapping("/name/{cardName}")
    public void deleteCardByName(@PathVariable String cardName) {
        cardService.deleteCardByName(cardName);
    }
}

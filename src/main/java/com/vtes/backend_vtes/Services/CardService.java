package com.vtes.backend_vtes.Services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.vtes.backend_vtes.Entities.Card;
import com.vtes.backend_vtes.Repositories.CardRepository;

@Service
public class CardService {
    @Autowired
    private CardRepository cardRepository;

    // GETTERS
    public List<Card> getAllCards() {
        return cardRepository.findAll();
    }

    public Optional<Card> getCardById(Integer id) {
        return cardRepository.findById(id);
    }

    public Card getCardByCardName(String cardName) {
        return cardRepository.findByCard_name(cardName);
    }

    public List<Card> getCardsByCardType(String cardType) {
        return (List<Card>) cardRepository.findByCard_type(cardType);
    }
    

    public List<Card> getCardsByClan(String clan) {
        return (List<Card>) cardRepository.findByClan(clan);
    }

    //SAVE
    public Card saveCard(Card card) {
        return cardRepository.save(card);
    }

    //UPDATE
    public Card updateCard(Card card) {
        Optional<Card> existingCard = cardRepository.findById(card.getCard_id());
        if (existingCard.isPresent()) {
            Card updatedCard = existingCard.get();
            updatedCard.setCard_name(card.getCard_name());
            updatedCard.setCard_url(card.getCard_url());
            updatedCard.setCard_type(card.getCard_type());
            updatedCard.setCard_text(card.getCard_text());
            updatedCard.setOrdered_sets(card.getOrdered_sets());
            updatedCard.setTitle(card.getTitle());
            updatedCard.setClan(card.getClan());
            updatedCard.setMultidiscipline(card.getMultidiscipline());
            updatedCard.setDisciplines(card.getDisciplines());
            updatedCard.setCapacity(card.getCapacity());
            updatedCard.setCost_pool(card.getCost_pool());
            updatedCard.setCost_blood(card.getCost_blood());
            updatedCard.setRulings(card.getRulings());
            updatedCard.setSets(card.getSets());
            updatedCard.setGroups(card.getGroups());
            return cardRepository.save(updatedCard);
        } else {
            throw new RuntimeException("Card not found with id: " + card.getCard_id());
        }
    }

    //DELETE
    public void deleteCard(Integer id) {
        cardRepository.deleteById(id);
    }

    //DELETE BY NAME
    public void deleteCardByName(String cardName) {
        cardRepository.deleteByCard_name(cardName);
    }

}

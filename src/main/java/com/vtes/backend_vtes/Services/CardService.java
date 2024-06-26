package com.vtes.backend_vtes.Services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agapsys.exception.RuntimeException;
import com.vtes.backend_vtes.Entities.Card;
import com.vtes.backend_vtes.Repositories.CardRepository;

@Service
public class CardService {
    @Autowired
    private CardRepository cardRepository;

    // GETTERS
    public List<Card> getAllCards() {
        try {
            return cardRepository.findAll();
        } catch (Exception e) {
            throw new RuntimeException("Error al obtener todas las cartas: " + e.getMessage());
        }
    }

    public Optional<Card> getCardById(Integer id) {
        try {
            return cardRepository.findById(id);
        } catch (Exception e) {
            throw new RuntimeException("Error al obtener la carta con ID " + id + ": " + e.getMessage());
        }
    }

    public Card getCardByCardName(String cardName) {
        try {
            return cardRepository.findByCard_name(cardName);
        } catch (Exception e) {
            throw new RuntimeException("Error al obtener la carta con nombre " + cardName + ": " + e.getMessage());
        }
    }

    public List<Card> getCardsByCardType(String cardType) {
        try {
            return cardRepository.findByCard_type(cardType);
        } catch (Exception e) {
            throw new RuntimeException("Error al obtener las cartas del tipo " + cardType + ": " + e.getMessage());
        }
    }

    public List<Card> getCardsByClan(String clan) {
        try {
            return cardRepository.findByClan(clan);
        } catch (Exception e) {
            throw new RuntimeException("Error al obtener las cartas del clan " + clan + ": " + e.getMessage());
        }
    }

    // SAVE
    public Card saveCard(Card card) {
        try {
            return cardRepository.save(card);
        } catch (Exception e) {
            throw new RuntimeException("Error al guardar la carta: " + e.getMessage());
        }
    }

    // UPDATE
    public Card updateCard(Card card) {
        try {
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
        } catch (Exception e) {
            throw new RuntimeException(
                    "Error al actualizar la carta con ID " + card.getCard_id() + ": " + e.getMessage());
        }
    }

    // DELETE
    public void deleteCard(Integer id) {
        try {
            cardRepository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("Error al eliminar la carta con ID " + id + ": " + e.getMessage());
        }
    }

    // DELETE BY NAME
    public void deleteCardByName(String cardName) {
        try{
            cardRepository.deleteByCard_name(cardName);
        }catch(Exception e){
            throw new RuntimeException("Error al eliminar la carta con nombre " + cardName + ": " + e.getMessage());
        }
    }

}

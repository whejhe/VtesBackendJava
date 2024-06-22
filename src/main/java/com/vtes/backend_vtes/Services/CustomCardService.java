package com.vtes.backend_vtes.Services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.vtes.backend_vtes.Entities.CustomCard;
import com.vtes.backend_vtes.Repositories.CustomCardRepository;

@Service
public class CustomCardService {
    @Autowired
    private CustomCardRepository customCardRepository;

    // GETTERS
    public List<CustomCard> getAllCustomCards() {
        return customCardRepository.findAll();
    }

    public Optional<CustomCard> getCustomCardById(Integer id) {
        return customCardRepository.findById(id);
    }

    public CustomCard getCustomCardByCustomCardName(String customCardName) {
        return customCardRepository.findByCustom_card_name(customCardName);
    }

    public List<CustomCard> getCustomCardsByAuthor(String author) {
        return (List<CustomCard>) customCardRepository.findByAuthor(author);
    }

    public List<CustomCard> getCustomCardsByClan(String clan) {
        return customCardRepository.findByClan(clan);
    }

    // SAVE
    public CustomCard saveCustomCard(CustomCard customCard) {
        return customCardRepository.save(customCard);
    }

    // UPDATE
    public CustomCard updateCustomCard(CustomCard customCard) {
        Optional<CustomCard> existingCustomCard = customCardRepository.findById(customCard.getCustom_card_id());
        if (existingCustomCard.isPresent()) {
            CustomCard updatedCustomCard = existingCustomCard.get();
            updatedCustomCard.setUser_id(customCard.getUser_id());
            updatedCustomCard.setCustom_card_name(customCard.getCustom_card_name());
            updatedCustomCard.setAuthor(customCard.getAuthor());
            updatedCustomCard.setCapacity(customCard.getCapacity());
            updatedCustomCard.setCustom_card_url(customCard.getCustom_card_url());
            updatedCustomCard.setClan(customCard.getClan());
            updatedCustomCard.setDisciplines(customCard.getDisciplines());
            updatedCustomCard.setGroup_vampire(customCard.getGroup_vampire());
            updatedCustomCard.setCustom_card_type(customCard.getCustom_card_type());
            updatedCustomCard.setLogo_color(customCard.getLogo_color());
            updatedCustomCard.setCustom_card_text(customCard.getCustom_card_text());
            updatedCustomCard.setIs_public(customCard.getIs_public());
            updatedCustomCard.setCost_pool(customCard.getCost_pool());
            updatedCustomCard.setCost_blood(customCard.getCost_blood());
            return customCardRepository.save(updatedCustomCard);
        } else {
            throw new RuntimeException("Custom card not found with id: " + customCard.getCustom_card_id());
        }
    }

    // DELETE
    public void deleteCustomCard(Integer id) {
        customCardRepository.deleteById(id);
    }

    // DELETE BY NAME
    public void deleteCustomCardByName(String customCardName) {
        customCardRepository.findByCustom_card_name(customCardName);
    }
}

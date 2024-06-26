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
        try{
            return (List<CustomCard>) customCardRepository.findAll();
            // return customCardRepository.findAll();
        }catch(Exception e){
            throw new RuntimeException("Error al obtener todas las cartas: " + e.getMessage());
        }
    }

    public Optional<CustomCard> getCustomCardById(Integer id) {
        try{
            return customCardRepository.findById(id);
        }catch(Exception e){
            throw new RuntimeException("Error al obtener la carta con ID " + id + ": " + e.getMessage());
        }
    }

    public CustomCard getCustomCardByCustomCardName(String customCardName) {
        try{
            return customCardRepository.findByCustom_card_name(customCardName);
        }catch(Exception e){
            throw new RuntimeException("Error al obtener la carta con nombre " + customCardName + ": " + e.getMessage());
        }
    }

    public List<CustomCard> getCustomCardsByAuthor(String author) {
        try{
            return (List<CustomCard>) customCardRepository.findByAuthor(author);
        }catch(Exception e){
            throw new RuntimeException("Error al obtener las cartas del autor " + author + ": " + e.getMessage());
        }
    }

    public List<CustomCard> getCustomCardsByClan(String clan) {
        try{
            return (List<CustomCard>) customCardRepository.findByClan(clan);
        }catch(Exception e){
            throw new RuntimeException("Error al obtener las cartas del clan " + clan + ": " + e.getMessage());
        }
    }

    // SAVE
    public CustomCard saveCustomCard(CustomCard customCard) {
        try{
            return customCardRepository.save(customCard);
        }catch(Exception e){
            throw new RuntimeException("Error al guardar la carta: " + e.getMessage());
        }
    }

    // UPDATE
    public CustomCard updateCustomCard(CustomCard customCard) {
        try{
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
        }catch(Exception e){
            throw new RuntimeException("Error al actualizar la carta: " + e.getMessage());
        }
    }

    // DELETE
    public void deleteCustomCard(Integer id) {
        try{
            customCardRepository.deleteById(id);
        }catch(Exception e){
            throw new RuntimeException("Error al eliminar la carta con ID " + id + ": " + e.getMessage());
        }
    }

    // DELETE BY NAME
    public void deleteCustomCardByName(String customCardName) {
        try{
            customCardRepository.findByCustom_card_name(customCardName);
        }catch(Exception e){
            throw new RuntimeException("Error al eliminar la carta con nombre " + customCardName + ": " + e.getMessage());
        }
    }
}

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
import com.vtes.backend_vtes.Entities.CustomCard;
import com.vtes.backend_vtes.Services.CustomCardService;

@RestController
@RequestMapping("/custom-cards")
public class CustomCardController {
    @Autowired
    private CustomCardService customCardService;

    @GetMapping
    public List<CustomCard> getAllCustomCards() {
        return customCardService.getAllCustomCards();
    }

    @GetMapping("/{id}")
    public Optional<CustomCard> getCustomCardById(@PathVariable Integer id) {
        return customCardService.getCustomCardById(id);
    }

    @GetMapping("/name/{customCardName}")
    public CustomCard getCustomCardByCustomCardName(@PathVariable String customCardName) {
        return customCardService.getCustomCardByCustomCardName(customCardName);
    }

    @GetMapping("/author/{author}")
    public List<CustomCard> getCustomCardsByAuthor(@PathVariable String author) {
        return customCardService.getCustomCardsByAuthor(author);
    }

    @GetMapping("/clan/{clan}")
    public List<CustomCard> getCustomCardsByClan(@PathVariable String clan) {
        return customCardService.getCustomCardsByClan(clan);
    }

    @PostMapping
    public CustomCard saveCustomCard(@RequestBody CustomCard customCard) {
        return customCardService.saveCustomCard(customCard);
    }

    @PutMapping("/{id}")
    public CustomCard updateCustomCard(@PathVariable Integer id, @RequestBody CustomCard customCard) {
        customCard.setCustom_card_id(id);
        return customCardService.saveCustomCard(customCard);
    }

    @DeleteMapping("/{id}")
    public void deleteCustomCard(@PathVariable Integer id) {
        customCardService.deleteCustomCard(id);
    }

    @DeleteMapping("/name/{customCardName}")
    public void deleteCustomCardByName(@PathVariable String customCardName) {
        customCardService.deleteCustomCardByName(customCardName);
    }
}

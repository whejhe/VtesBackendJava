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
import com.vtes.backend_vtes.Entities.Crypt;
import com.vtes.backend_vtes.Services.CryptService;

@RestController
@RequestMapping("/crypts")
public class CryptController {
    @Autowired
    private CryptService cryptService;

    @GetMapping
    public List<Crypt> getAllCrypts() {
        try {
            return cryptService.getAllCrypts();
        } catch (Exception e) {
            throw new RuntimeException("Error al obtener todas las crypts: " + e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public Optional<Crypt> getCryptById(@PathVariable Integer id) {
        try {
            return cryptService.getCryptById(id);
        } catch (Exception e) {
            throw new RuntimeException("Error al obtener la crypt con ID " + id + ": " + e.getMessage());
        }
    }

    @GetMapping("/user/{userId}")
    public List<Crypt> getCryptsByUserId(@PathVariable Integer userId) {
        try {
            return cryptService.getCryptsByUserId(userId);
        } catch (Exception e) {
            throw new RuntimeException(
                    "Error al obtener las crypts del usuario con ID " + userId + ": " + e.getMessage());
        }
    }

    @GetMapping("/deck/{deckId}")
    public List<Crypt> getCryptsByDeckId(@PathVariable Integer deckId) {
        try {
            return cryptService.getCryptsByDeckId(deckId);
        } catch (Exception e) {
            throw new RuntimeException("Error al obtener las crypts del deck con ID " + deckId + ": " + e.getMessage());
        }
    }

    @GetMapping("/card/{cardId}")
    public List<Crypt> getCryptsByCardId(@PathVariable Integer cardId) {
        try {
            return cryptService.getCryptsByCardId(cardId);
        } catch (Exception e) {
            throw new RuntimeException(
                    "Error al obtener las crypts de la carta con ID " + cardId + ": " + e.getMessage());
        }
    }

    @PostMapping
    public Crypt saveCrypt(@RequestBody Crypt crypt) {
        try {
            return cryptService.saveCrypt(crypt);
        } catch (Exception e) {
            throw new RuntimeException("Error al guardar la crypt: " + e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public Crypt updateCrypt(@PathVariable Integer id, @RequestBody Crypt crypt) {
        try {
            Optional<Crypt> existingCrypt = cryptService.getCryptById(id);
            if (existingCrypt.isPresent()) {
                crypt.setCryptId(id);
                return cryptService.updateCrypt(crypt);
            } else {
                throw new RuntimeException("Crypt not found with id: " + id);
            }
        } catch (Exception e) {
            throw new RuntimeException("Error al actualizar la crypt con ID " + id + ": " + e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public void deleteCrypt(@PathVariable Integer id) {
        try {
            cryptService.deleteCrypt(id);
        }catch(Exception e){
            throw new RuntimeException("Error al eliminar la crypt con ID " + id + ": " + e.getMessage());
        }
    }

    @DeleteMapping("/user/{userId}")
    public void deleteCryptsByUserId(@PathVariable Integer userId) {
        try{
            cryptService.deleteCryptsByUserId(userId);
        }catch(Exception e){
            throw new RuntimeException("Error al eliminar las crypts del usuario con ID " + userId + ": " + e.getMessage());
        }
    }

    @DeleteMapping("/deck/{deckId}")
    public void deleteCryptsByDeckId(@PathVariable Integer deckId) {
        try{
            cryptService.deleteCryptsByDeckId(deckId);
        }catch(Exception e){
            throw new RuntimeException("Error al eliminar las crypts del deck con ID " + deckId + ": " + e.getMessage());
        }
    }

    @DeleteMapping("/card/{cardId}")
    public void deleteCryptsByCardId(@PathVariable Integer cardId) {
        try{
            cryptService.deleteCryptsByCardId(cardId);
        }catch(Exception e){
            throw new RuntimeException("Error al eliminar las crypts de la carta con ID " + cardId + ": " + e.getMessage());
        }
    }
}

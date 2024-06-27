package com.vtes.backend_vtes.Services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.vtes.backend_vtes.Entities.Crypt;
import com.vtes.backend_vtes.Repositories.CryptRepository;

@Service
public class CryptService {
    @Autowired
    private CryptRepository cryptRepository;

    // GETTERS
    public List<Crypt> getAllCrypts() {
        return cryptRepository.findAll();
    }

    public Optional<Crypt> getCryptById(Integer id) {
        return cryptRepository.findById(id);
    }

    public List<Crypt> getCryptsByUserId(Integer userId) {
        return cryptRepository.findByUserId(userId);
    }

    public List<Crypt> getCryptsByDeckId(Integer deckId) {
        return cryptRepository.findByDeckId(deckId);
    }

    public List<Crypt> getCryptsByCardId(Integer cardId) {
        return cryptRepository.findByCardId(cardId);
    }

    // SAVE
    public Crypt saveCrypt(Crypt crypt) {
        return cryptRepository.save(crypt);
    }

    // UPDATE
    public Crypt updateCrypt(Crypt crypt) {
        Optional<Crypt> existingCrypt = cryptRepository.findById(crypt.getCryptId());
        if (existingCrypt.isPresent()) {
            Crypt updatedCrypt = existingCrypt.get();
            updatedCrypt.setUserId(crypt.getUserId());
            updatedCrypt.setDeckId(crypt.getDeckId());
            updatedCrypt.setCardId(crypt.getCardId());
            return cryptRepository.save(updatedCrypt);
        } else {
            throw new RuntimeException("Crypt not found with id: " + crypt.getCryptId());
        }
    }

    // DELETE
    public void deleteCrypt(Integer id) {
        cryptRepository.deleteById(id);
    }

    // DELETE BY USER ID
    public void deleteCryptsByUserId(Integer userId) {
        cryptRepository.deleteByUserId(userId);
    }

    // DELETE BY DECK ID
    public void deleteCryptsByDeckId(Integer deckId) {
        cryptRepository.deleteByDeckId(deckId);
    }

    // DELETE BY CARD ID
    public void deleteCryptsByCardId(Integer cardId) {
        cryptRepository.deleteByCardId(cardId);
    }
}

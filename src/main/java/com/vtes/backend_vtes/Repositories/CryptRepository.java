package com.vtes.backend_vtes.Repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.vtes.backend_vtes.Entities.Crypt;

@Repository
public interface CryptRepository extends JpaRepository<Crypt, Integer> {

    // finders
    Crypt findByCryptId(Integer cryptId);

    List<Crypt> findByUserId(Integer userId);

    List<Crypt> findByDeckId(Integer deckId);

    List<Crypt> findByCardId(Integer cardId);

    // delete
    void deleteByCryptId(Integer cryptId);

    void deleteByUserId(Integer userId);

    void deleteByDeckId(Integer deckId);

    void deleteByCardId(Integer cardId);

    void deleteByUserIdAndDeckId(Integer userId, Integer deckId);
}

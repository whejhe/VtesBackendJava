package com.vtes.backend_vtes.Repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.vtes.backend_vtes.Entities.Card;

@Repository
public interface CardRepository extends JpaRepository<Card, Integer> {

    Card findByCardId(Integer cardId);

    Card findByCardName(String cardName);

    List<Card> findByClan(String clan);

    List<Card> findByDisciplines(String disciplines);

    List<Card> findByCardType(String cardType);

    //DELETE BY NAME
    void deleteByCardName(String cardName);

}

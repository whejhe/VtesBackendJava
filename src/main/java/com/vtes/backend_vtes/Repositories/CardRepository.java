package com.vtes.backend_vtes.Repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.vtes.backend_vtes.Entities.Card;

@Repository
public interface CardRepository extends JpaRepository<Card, Integer> {

    Card findByCard_id(Integer card_id);

    Card findByCard_name(String card_name);

    List<Card> findByClan(String clan);

    List<Card> findByDisciplines(String disciplines);

    List<Card> findByCard_type(String card_type);

    //DELETE BY NAME
    void deleteByCard_name(String card_name);

}

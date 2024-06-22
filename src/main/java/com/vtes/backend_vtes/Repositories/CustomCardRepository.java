package com.vtes.backend_vtes.Repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.vtes.backend_vtes.Entities.CustomCard;

@Repository
public interface CustomCardRepository extends JpaRepository<CustomCard, Integer> {

    // finders
    CustomCard findByCustom_card_id(Integer custom_card_id);

    List<CustomCard> findByUser_id(Integer user_id);

    CustomCard findByCustom_card_name(String custom_card_name);

    List<CustomCard> findByAuthor(String author);

    List<CustomCard> findByClan(String clan);

    List<CustomCard> findByDisciplines(String disciplines);

    List<CustomCard> findByCustom_card_type(String custom_card_type);

    // DELETE BY NAME
    void deleteByCustom_card_name(String custom_card_name);

    // DELETE BY ID
    void deleteByCustom_card_id(Integer custom_card_id);

    // DELETE BY AUTHOR
    void deleteByAuthor(String author);
}

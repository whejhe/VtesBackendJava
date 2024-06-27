package com.vtes.backend_vtes.Repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.vtes.backend_vtes.Entities.CustomCard;

@Repository
public interface CustomCardRepository extends JpaRepository<CustomCard, Integer> {

    // finders
    CustomCard findByCustomCardId(Integer customCardId);

    List<CustomCard> findByUserId(Integer userId);

    CustomCard findByCustomCardName(String customCardName);

    List<CustomCard> findByAuthor(String author);

    List<CustomCard> findByClan(String clan);

    List<CustomCard> findByDisciplines(String disciplines);

    List<CustomCard> findByCustomCardType(String customCardType);

    // DELETE BY NAME
    void deleteByCustomCardName(String customCardName);

    // DELETE BY ID
    void deleteByCustomCardId(Integer customCardId);

    // DELETE BY AUTHOR
    void deleteByAuthor(String author);
}

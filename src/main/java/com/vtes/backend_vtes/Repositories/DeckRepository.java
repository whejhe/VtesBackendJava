package com.vtes.backend_vtes.Repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.vtes.backend_vtes.Entities.Deck;

@Repository
public interface DeckRepository extends JpaRepository<Deck, Integer> {

    Deck findByDeck_id(Integer deck_id);

    Deck findByUser_id(Integer user_id);

    Deck findByDeck_name(String deck_name);

    List<Deck> findByAuthor(String author);

    List<Deck> findByCategory(String category);

    void deleteDeckByAuthor(String author);
}

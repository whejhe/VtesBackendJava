package com.vtes.backend_vtes.Repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.vtes.backend_vtes.Entities.Library;

@Repository
public interface LibraryRepository extends JpaRepository<Library, Integer> {

    Library findByLibrary_id(Integer library_id);

    List<Library> findByUser_id(Integer user_id);

    List<Library> findByDeck_id(Integer deck_id);

    List<Library> findByCard_id(Integer card_id);

    List<Library> findByUser_idAndDeck_id(Integer user_id, Integer deck_id);

    List<Library> findByUser_idAndCard_id(Integer user_id, Integer card_id);

    List<Library> findByDeck_idAndCard_id(Integer deck_id, Integer card_id);

   //Delete

    void deleteByLibrary_id(Integer library_id);

    void deleteByUser_id(Integer user_id);

    void deleteByDeck_id(Integer deck_id);

    void deleteByCard_id(Integer card_id);
}

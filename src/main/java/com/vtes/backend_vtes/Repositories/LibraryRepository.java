package com.vtes.backend_vtes.Repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.vtes.backend_vtes.Entities.Library;

@Repository
public interface LibraryRepository extends JpaRepository<Library, Integer> {

    Library findByLibraryId(Integer libraryId);

    List<Library> findByUserId(Integer userId);

    List<Library> findByDeckId(Integer deckId);

    List<Library> findByCardId(Integer cardId);

    List<Library> findByUserIdAndDeckId(Integer userId, Integer deckId);

    List<Library> findByUserIdAndCardId(Integer userId, Integer cardId);

    List<Library> findByDeckIdAndCardId(Integer deckId, Integer cardId);

   //Delete

    void deleteByLibraryId(Integer libraryId);

    void deleteByUserId(Integer userId);

    void deleteByDeckId(Integer deckId);

    void deleteByCardId(Integer cardId);
}

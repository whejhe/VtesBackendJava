package com.vtes.backend_vtes.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.vtes.backend_vtes.Entities.Library;

@Repository
public interface LibraryRepository extends JpaRepository<Library, Integer> {

    // finders
    Library findByLibrary_id(Integer library_id);

    Library findByUser_id(Integer user_id);

    Library findByDeck_id(Integer deck_id);

    Library findByCard_id(Integer card_id);

    // no need to define save(), delete() and update() methods, they are already defined in JpaRepository
}

package com.vtes.backend_vtes.Repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.vtes.backend_vtes.Entities.Crypt;

@Repository
public interface CryptRepository extends JpaRepository<Crypt, Integer> {

    // finders
    Crypt findByCrypt_id(Integer crypt_id);

    List<Crypt> findByUser_id(Integer user_id);

    List<Crypt> findByDeck_id(Integer deck_id);

    List<Crypt> findByCard_id(Integer card_id);

    // delete
    void deleteByCrypt_id(Integer crypt_id);

    void deleteByUser_id(Integer user_id);

    void deleteByDeck_id(Integer deck_id);

    void deleteByCard_id(Integer card_id);

    void deleteByUser_idAndDeck_id(Integer user_id, Integer deck_id);
}

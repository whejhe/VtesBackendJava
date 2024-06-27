package com.vtes.backend_vtes.Repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.vtes.backend_vtes.Entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    
    User findByUserId(Integer userId);

    User findByEmail(String email);
    
    User findByNick(String nick);
    
    User findByPhone(String phone);
    
    List<User> findByUsername(String username);

    List<User> findByCity(String city);

    List<User> findByCountry(String country);

    //DELETE BY EMAIL
    void deleteByEmail(String email);

}

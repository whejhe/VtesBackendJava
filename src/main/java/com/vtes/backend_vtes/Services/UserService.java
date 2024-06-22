package com.vtes.backend_vtes.Services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.vtes.backend_vtes.Entities.User;
import com.vtes.backend_vtes.Repositories.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(Integer id) {
        return userRepository.findById(id);
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public void deleteUser(Integer id) {
        userRepository.deleteById(id);
    }

    public User updateUser(User user) {
        Optional<User> existingUser = userRepository.findById(user.getUser_id());
        if (existingUser.isPresent()) {
            User updatedUser = existingUser.get();
            updatedUser.setUsername(user.getUsername());
            updatedUser.setLastname(user.getLastname());
            updatedUser.setBirthdate(user.getBirthdate());
            updatedUser.setCountry(user.getCountry());
            updatedUser.setCity(user.getCity());
            updatedUser.setAddress(user.getAddress());
            updatedUser.setPhone(user.getPhone());
            updatedUser.setState_account(user.getState_account());
            updatedUser.setNick(user.getNick());
            updatedUser.setEmail(user.getEmail());
            updatedUser.setAvatar_url(user.getAvatar_url());
            updatedUser.setPassword(user.getPassword());
            return userRepository.save(updatedUser);
        } else {
            throw new RuntimeException("User not found with id: " + user.getUser_id());
        }
    }

    public List<User> getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public User getUserByNick(String nick) {
        return userRepository.findByNick(nick);
    }

    public User getUserByPhone(String phone) {
        return userRepository.findByPhone(phone);
    }

    public List<User> getUserByCity(String city) {
        return userRepository.findByCity(city);
    }

    public List<User> getUserByCountry(String country) {
        return userRepository.findByCountry(country);
    }
}

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
        try {
            return userRepository.findAll();
        } catch (Exception e) {
            throw new RuntimeException("Error al obtener todos los usuarios: " + e.getMessage());
        }
    }

    public Optional<User> getUserById(Integer id) {
        try {
            return userRepository.findById(id);
        } catch (Exception e) {
            throw new RuntimeException("Error al obtener el usuario con ID " + id + ": " + e.getMessage());
        }
    }

    public User saveUser(User user) {
        try {
            return userRepository.save(user);
        } catch (Exception e) {
            throw new RuntimeException("Error al guardar el usuario: " + e.getMessage());
        }
    }

    public void deleteUser(Integer id) {
        try {
            userRepository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("Error al eliminar el usuario con ID " + id + ": " + e.getMessage());
        }
    }

    public User updateUser(User user) {
        try {
            Optional<User> existingUser = userRepository.findById(user.getUserId());
            if (existingUser.isPresent()) {
                User updatedUser = existingUser.get();
                updatedUser.setUsername(user.getUsername());
                updatedUser.setLastname(user.getLastname());
                updatedUser.setBirthdate(user.getBirthdate());
                updatedUser.setCountry(user.getCountry());
                updatedUser.setCity(user.getCity());
                updatedUser.setAddress(user.getAddress());
                updatedUser.setPhone(user.getPhone());
                updatedUser.setStateAccount(user.getStateAccount());
                updatedUser.setNick(user.getNick());
                updatedUser.setEmail(user.getEmail());
                updatedUser.setAvatarUrl(user.getAvatarUrl());
                updatedUser.setPassword(user.getPassword());
                return userRepository.save(updatedUser);
            } else {
                throw new RuntimeException("User not found with id: " + user.getUserId());
            }
        } catch (Exception e) {
            throw new RuntimeException("Error al actualizar el usuario: " + e.getMessage());
        }
    }

    public List<User> getUserByUsername(String username) {
        try {
            return userRepository.findByUsername(username);
        } catch (Exception e) {
            throw new RuntimeException("Error al obtener el usuario con username " + username + ": " + e.getMessage());
        }
    }

    public User getUserByEmail(String email) {
        try {
            return userRepository.findByEmail(email);
        } catch (Exception e) {
            throw new RuntimeException("Error al obtener el usuario con email " + email + ": " + e.getMessage());
        }
    }

    public User getUserByNick(String nick) {
        try {
            return userRepository.findByNick(nick);
        } catch (Exception e) {
            throw new RuntimeException("Error al obtener el usuario con nick " + nick + ": " + e.getMessage());
        }
    }

    public User getUserByPhone(String phone) {
        try {
            return userRepository.findByPhone(phone);
        } catch (Exception e) {
            throw new RuntimeException("Error al obtener el usuario con phone " + phone + ": " + e.getMessage());
        }
    }

    public List<User> getUserByCity(String city) {
        try {
            return userRepository.findByCity(city);
        } catch (Exception e) {
            throw new RuntimeException("Error al obtener el usuario con city " + city + ": " + e.getMessage());
        }
    }

    public List<User> getUserByCountry(String country) {
        try {
            return userRepository.findByCountry(country);
        } catch (Exception e) {
            throw new RuntimeException("Error al obtener el usuario con country " + country + ": " + e.getMessage());
        }
    }
}

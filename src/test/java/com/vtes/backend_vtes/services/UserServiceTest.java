package com.vtes.backend_vtes.services;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.vtes.backend_vtes.Entities.User;
import com.vtes.backend_vtes.Repositories.UserRepository;
import com.vtes.backend_vtes.Services.UserService;



@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @Test
    public void testGetAllUsers() {
        User user1 = new User(1, "John", "Doe", "1990-01-01", "USA", "New York", "123 Main St", "1234567890", true, "johndoe", "johndoe@example.com", "https://example.com/johndoe.jpg", "password");
        User user2 = new User(2, "Jane", "Doe", "1995-02-02", "USA", "Los Angeles", "456 Elm St", "0987654321", false, "janedoe", "janedoe@example.com", "https://example.com/janedoe.jpg", "password");
        List<User> users = Arrays.asList(user1, user2);

        when(userRepository.findAll()).thenReturn(users);

        List<User> result = userService.getAllUsers();

        assertThat(result).isEqualTo(users);
    }

    @Test
    public void testGetUserById() {
        User user = new User(1, "John", "Doe", "1990-01-01", "USA", "New York", "123 Main St", "1234567890", true, "johndoe", "johndoe@example.com", "https://example.com/johndoe.jpg", "password");

        when(userRepository.findById(1)).thenReturn(Optional.of(user));

        Optional<User> result = userService.getUserById(1);

        assertThat(result).isEqualTo(Optional.of(user));

        when(userRepository.findById(2)).thenReturn(Optional.empty());

        result = userService.getUserById(2);

        assertThat(result).isEmpty();    
    }

    @Test
    public void testSaveUser() {
        User user = new User(1, "John", "Doe", "1990-01-01", "USA", "New York", "123 Main St", "1234567890", true, "johndoe", "johndoe@example.com", "https://example.com/johndoe.jpg", "password");

        when(userRepository.save(user)).thenReturn(user);

        User result = userService.saveUser(user);

        assertThat(result).isEqualTo(user);
    }

    @Test
    public void testUpdateUser() {
        User user = new User(1, "John", "Doe", "1990-01-01", "USA", "New York", "123 Main St", "1234567890", true, "johndoe", "johndoe@example.com", "https://example.com/johndoe.jpg", "password");

        when(userRepository.findById(1)).thenReturn(Optional.of(user));
        when(userRepository.save(user)).thenReturn(user);

        User updatedUser = new User(1, "John", "Smith", "1990-01-01", "USA", "New York", "123 Main St", "1234567890", true, "johndoe", "johndoe@example.com", "https://example.com/johndoe.jpg", "password");

        User result = userService.updateUser(updatedUser);

        assertThat(result).isEqualTo(updatedUser);
    }

    @Test
    public void testDeleteUser() {
        User user = new User(1, "John", "Doe", "1990-01-01", "USA", "New York", "123 Main St", "1234567890", true, "johndoe", "johndoe@example.com", "https://example.com/johndoe.jpg", "password");

        userService.deleteUser(user.getUser_id());

        // verify that the deleteById method was called with the correct argument
        verify(userRepository, times(1)).deleteById(user.getUser_id());
    }
}

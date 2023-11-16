package com.mongospring.mongosp.controller;

import com.mongospring.mongosp.documents.User;
import com.mongospring.mongosp.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class UserControllerTest {
    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserController userController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getAllUsers() {
        List<User> users = Arrays.asList(new User(1, "josue", "josue@gmail.com"));

        when(userRepository.findAll()).thenReturn(Arrays.asList(new User(1, "josue", "josue@gmail.com")));
        assertArrayEquals(users.toArray(), userRepository.findAll().toArray());
    }

    @Test
    void getUser() {
        Integer userId = 1;
        User user = new User(userId, "josue", "josue@gmail.com");
        when(userRepository.findById(userId)).thenReturn(Optional.of(user));

        Optional<User> retrievedUser = userRepository.findById(userId);

        assertTrue(retrievedUser.isPresent());
        assertEquals(user, retrievedUser.get());
    }
}
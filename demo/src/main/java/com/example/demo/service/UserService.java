package com.example.demo.service;

import com.example.demo.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User getUserById(Long userId);
    User createUser(User user);
    User editUser(Long userId, User updatedUser);
    void deleteUser(Long userId);
    Optional<User> getUserByEmail(String email);
    List<User> getAllUsers();
    boolean userExists(Long userId);
}

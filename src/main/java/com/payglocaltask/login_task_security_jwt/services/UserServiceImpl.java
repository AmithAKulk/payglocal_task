package com.payglocaltask.login_task_security_jwt.services;

import com.payglocaltask.login_task_security_jwt.model.User;
import com.payglocaltask.login_task_security_jwt.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User registerUser(User user) {
        // Check if the username is already taken
        if (userRepository.findByUsername(user.getUsername()) != null) {
            throw new RuntimeException("Username is already taken");
        }

        // Check if the email is already registered
        if (userRepository.findByEmail(user.getEmail()) != null) {
            throw new RuntimeException("Email is already registered");
        }

        // Set default role to "User" if not provided
        if (user.getRol() == null || user.getRol().isEmpty()) {
            user.setRol("User");
        }

        // Set default enabled status to true if not provided
        if (!user.isEnabled()) {
            user.setEnabled(true);
        }

        // Add additional validation or logic as needed

        // Save the user to the database
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Long userId) {
        Optional<User> optionalUser = userRepository.findById(userId);
        if (optionalUser.isPresent()) {
            return optionalUser.get();
        } else {
            throw new RuntimeException("User not found with id: " + userId);
        }
    }

    @Override
    public void deleteUser(Long userId) {
        if (userRepository.existsById(userId)) {
            userRepository.deleteById(userId);
        } else {
            throw new RuntimeException("User not found with id: " + userId);
        }
    }

}
package com.example.dd.dd.Services;

import com.example.dd.dd.Entities.User;
import com.example.dd.dd.Repositories.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        logger.info("Fetching all users");
        return userRepository.findAll();
    }

    public Optional<User> getUserById(Long id) {
        logger.info("Fetching user with id: {}", id);
        return userRepository.findById(id);
    }

    @Transactional
    public User createUser(User user) {
        logger.info("Creating user: {}", user);
        return userRepository.save(user);
    }

    @Transactional
    public void deleteUser(Long id) {
        logger.info("Deleting user with id: {}", id);
        userRepository.deleteById(id);
    }

    @Transactional
    public User updateUser(Long id, User updatedUser) {
        Optional<User> existingUserOptional = userRepository.findById(id);

        if (existingUserOptional.isPresent()) {
            User existingUser = existingUserOptional.get();

            // Update the fields with the new data
            existingUser.setUsername(updatedUser.getUsername()); // Use setUsername
            existingUser.setEmail(updatedUser.getEmail());       // Use setEmail
            existingUser.setPassword(updatedUser.getPassword()); // Use setPassword

            // Save and return the updated user
            return userRepository.save(existingUser);
        } else {
            throw new EntityNotFoundException("User not found with id: " + id);
        }
    }

}

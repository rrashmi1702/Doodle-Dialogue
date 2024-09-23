package com.example.dd.dd.Controller;

import com.example.dd.dd.Entities.User;
import com.example.dd.dd.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();

    }
    @GetMapping("/")
    public String home() {
        return "User";  // This will map to src/main/resources/templates/index.html
    }

    @GetMapping("/{id}")
    public Optional<User> getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

//    @PostMapping
//    public User createUser(@RequestBody User user) {
//        return userService.createUser(user);
//    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }

//    @PostMapping("/signup")
//    public ResponseEntity<String> createUser(@RequestBody User user) {
//        // Check if user already exists by email (to prevent duplicate sign-ups)
//        if (userService.findByEmail(user.getEmail()).isPresent()) {
//            return ResponseEntity.status(HttpStatus.CONFLICT).body("Email already in use");
//        }
//
//        // Save the user
//        User createdUser = userService.createUser(user);
//
//        return ResponseEntity.ok("User registered successfully");
//    }
@PostMapping("/signup")
public ResponseEntity<String> createUser(@RequestBody User user) {
    // Check if user already exists
//    if (userService.findByEmail(user.getEmail()).isPresent()) {
//        return ResponseEntity.status(409).body("Email already in use");
//    }

    // Save user to database
    userService.createUser(user);
    return ResponseEntity.ok("User registered successfully");
}

}

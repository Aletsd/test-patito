package com.store.back.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.store.back.models.entity.User;

import exception.UserNotFoundException;

@RestController
@RequestMapping("/api/users")
public class UserController {
	
	private List<User> users = new ArrayList<User>();

    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody User user) {
        users.add(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User user) {
        User existingUser = findUserById(id);

        if (existingUser == null) {
            throw new UserNotFoundException("User not found with ID: " + id);
        }

        existingUser.setUsername(user.getUsername());
        existingUser.setPassword(user.getPassword());

        return ResponseEntity.ok(existingUser);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        User user = findUserById(id);

        if (user == null) {
            throw new UserNotFoundException("User not found with ID: " + id);
        }

        users.remove(user);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/find")
    public ResponseEntity<User> findUser(@RequestParam String username, @RequestParam String password) {
        User user = users.stream()
                .filter(u -> u.getUsername().equals(username) && u.getPassword().equals(password))
                .findFirst()
                .orElse(null);

        if (user == null) {
            throw new UserNotFoundException("User not found with provided credentials.");
        }

        return ResponseEntity.ok(user);
    }

    @GetMapping("/all")
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(users);
    }

    private User findUserById(Long id) {
        return users.stream()
                .filter(user -> user.getUserId().equals(id))
                .findFirst()
                .orElse(null);
    }
}

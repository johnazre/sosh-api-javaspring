package com.sosh.api.controllers;

import com.sosh.api.exceptions.NotFoundException;
import com.sosh.api.repositories.UserRepository;
import com.sosh.api.models.User;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@RestController
public class UserController {

    private final UserRepository repository;

    UserController(UserRepository repository) {
        this.repository = repository;
    }

    // Get all users

    @GetMapping("/users")
    List<User> getAllUsers() {
        return repository.findAll();
    }

    @GetMapping("/users/{id}")
    User getOneUser(@PathVariable Long id) {
        return repository
                .findById(id)
                .orElseThrow(() -> new NotFoundException("user", id));
    }

    @PostMapping("/users")
    User newUser(@RequestBody User newUser) {
        newUser.setCreated_at(new Date());
        newUser.setUpdated_at(new Date());
        return repository.save(newUser);
    }

//    @PatchMapping("/users/{id}")
//    User replaceUser(@RequestBody User newUser, @PathVariable Long id) {
//        return repository.findById(id)
//                .map(message -> {
//                    message.set
//                });
//    }

    @DeleteMapping("/users/{id}")
    void deleteUser(@PathVariable Long id) {
        repository.deleteById(id);
    }


}

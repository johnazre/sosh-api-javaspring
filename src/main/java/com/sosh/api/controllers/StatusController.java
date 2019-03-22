package com.sosh.api.controllers;

import com.sosh.api.exceptions.NotFoundException;
import com.sosh.api.models.User;
import com.sosh.api.repositories.StatusRepository;
import com.sosh.api.models.Status;
import com.sosh.api.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
public class StatusController {

    @Autowired
    private StatusRepository statusRepository;

    @Autowired
    private UserRepository userRepository;

    // Get all statuses

    @GetMapping("/statuses")
    List<Status> getAllStatuses() {
        return statusRepository.findAll();
    }

    @GetMapping("/statuses/{id}")
    Optional<Status> getOneStatus(@PathVariable Long id) {
        return statusRepository.findById(id);
    }

    @PostMapping("/statuses/{author_id}")
    Status newStatus(@RequestBody Status newStatus, @PathVariable Long author_id) {
        newStatus.setCreated_at(new Date());
        newStatus.setUpdated_at(new Date());
        User u = userRepository
                .findById(author_id)
                .orElseThrow(() -> new NotFoundException("user", author_id));
        newStatus.setAuthor(u);
        return statusRepository.save(newStatus);
    }

//    @PatchMapping("/statuses/{id}")
//    Status replaceStatus(@RequestBody Status newStatus, @PathVariable Long id) {
//        return statusRepository.findById(id)
//                .map(message -> {
//                    message.set
//                });
//    }

    @DeleteMapping("/statuses/{id}")
    void deleteStatus(@PathVariable Long id) {
        statusRepository.deleteById(id);
    }


}

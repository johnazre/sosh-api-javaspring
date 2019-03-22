package com.sosh.api.controllers;

import com.sosh.api.models.Message;
import com.sosh.api.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.sosh.api.repositories.MessageRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
public class MessageController {

    @Autowired
    private MessageRepository messageRepository;

    @Autowired
    private UserRepository userRepository;

    // Get all messages

    @GetMapping("/messages")
    List<Message> getAllMessages() {
        return messageRepository.findAll();
    }

    @GetMapping("/messages/{id}")
    Optional<Message> getOneMessage(@PathVariable Long id) {
        return messageRepository.findById(id);
    }

    @PostMapping("/messages")
    Message newMessage(@RequestBody Message newMessage) {
        newMessage.setCreated_at(new Date());
        return messageRepository.save(newMessage);
    }

//    @PatchMapping("/messages/{id}")
//    Message replaceMessage(@RequestBody Message newMessage, @PathVariable Long id) {
//        return messageRepository.findById(id)
//                .map(message -> {
//                    message.set
//                });
//    }

    @DeleteMapping("/messages/{id}")
    void deleteMessage(@PathVariable Long id) {
        messageRepository.deleteById(id);
    }


}

package com.sosh.api.controllers;

import com.sosh.api.exceptions.NotFoundException;
import com.sosh.api.models.Message;
import com.sosh.api.models.User;
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
    Message newMessage(@RequestBody Message newMessage, @RequestParam Long sender_id, @RequestParam Long recipient_id) {
        newMessage.setCreated_at(new Date());
        User sender = userRepository
                .findById(sender_id)
                .orElseThrow(() -> new NotFoundException("user", sender_id));
        User recipient = userRepository
                .findById(recipient_id)
                .orElseThrow(() -> new NotFoundException("user", recipient_id));
        newMessage.setSender(sender);
        newMessage.setRecipient(recipient);
        return messageRepository.save(newMessage);
    }

    @DeleteMapping("/messages/{id}")
    void deleteMessage(@PathVariable Long id) {
        messageRepository.deleteById(id);
    }


}

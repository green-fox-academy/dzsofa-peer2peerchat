package com.greenfox.p2pchat.services;

import com.greenfox.p2pchat.models.Message;
import com.greenfox.p2pchat.repositories.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MessageService {

    @Autowired
    MessageRepository messageRepository;

    @Autowired
    ChatUserService userService;

    public Iterable<Message> listAllMessages() {
        return messageRepository.findAll();
    }

    public void save(Message message) {
        messageRepository.save(message);
    }
}

package com.greenfox.p2pchat.services;

import com.greenfox.p2pchat.models.Client;
import com.greenfox.p2pchat.models.Message;
import com.greenfox.p2pchat.models.Status;
import com.greenfox.p2pchat.models.Wrapper;
import com.greenfox.p2pchat.repositories.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class MessageService {

    @Autowired
    MessageRepository messageRepository;

    @Autowired
    ChatUserService userService;

    public Iterable<Message> listAllMessages() {
        return messageRepository.findAll();
    }

    public void setUser(Message message) {
        message.setUsername(userService.findActive().getUsername());
    }

    public void save(Message message) {
        messageRepository.save(message);
    }

    public void sendMessage(Message message) {
        Wrapper wrapper = new Wrapper(message, new Client());
        RestTemplate template = new RestTemplate();
        String url = "https://dzsofap2p.herokuapp.com/api/message/receive";
        Status response = template.postForObject(url, wrapper, Status.class);
        System.out.println(response.getStatus());
        System.out.println(response.getMessage());
    }
}

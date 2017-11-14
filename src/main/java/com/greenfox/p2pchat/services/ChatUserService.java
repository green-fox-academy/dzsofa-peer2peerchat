package com.greenfox.p2pchat.services;

import com.greenfox.p2pchat.models.ChatUser;
import com.greenfox.p2pchat.repositories.ChatUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ChatUserService {

    @Autowired
    ChatUserRepository chatUserRepository;

    public ChatUser findActive() {
        return chatUserRepository.findOne(1l);
    }

    public void save(ChatUser user) {
        chatUserRepository.save(user);
    }

    public Iterable<ChatUser> getUserList() {
        return chatUserRepository.findAll();
    }

    public boolean hasEntry(){
        return chatUserRepository.exists(1l);
    }

//    public boolean checkIfUserExists(String name) {
//       return chatUserRepository.findChatUserByNameExists(name);
//    }

//    public ChatUser checkIfExists() {
//
//    }
}

package com.greenfox.p2pchat.services;

import com.greenfox.p2pchat.models.ChatUser;
import com.greenfox.p2pchat.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserService {

    @Autowired
    UserRepository userRepository;

    public void save(String name) {
        userRepository.save(new ChatUser(name));
    }

    public Iterable<ChatUser> getUserList() {
        return userRepository.findAll();
    }

    public List<ChatUser> getSelectedUser() {
        return userRepository.findOneByName();
    }

//    public ChatUser checkIfExists() {
//
//    }
}

package com.greenfox.p2pchat.repositories;

import com.greenfox.p2pchat.models.ChatUser;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<ChatUser, Long>{

    List<ChatUser> findOneByName();

    ChatUser findOneByNameExists();
}

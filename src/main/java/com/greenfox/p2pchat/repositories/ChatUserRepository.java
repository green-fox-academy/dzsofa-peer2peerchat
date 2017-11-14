package com.greenfox.p2pchat.repositories;

import com.greenfox.p2pchat.models.ChatUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChatUserRepository extends CrudRepository<ChatUser, Long> {
}

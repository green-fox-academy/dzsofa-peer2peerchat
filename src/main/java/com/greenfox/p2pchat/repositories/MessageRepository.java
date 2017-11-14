package com.greenfox.p2pchat.repositories;

import com.greenfox.p2pchat.models.Message;
import org.springframework.data.repository.CrudRepository;

public interface MessageRepository extends CrudRepository<Message, Integer> {
}

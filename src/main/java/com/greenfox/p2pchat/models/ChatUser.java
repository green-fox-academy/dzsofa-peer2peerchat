package com.greenfox.p2pchat.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Component
@Entity
@Table(name = "users")
public class ChatUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String noUserName;

    private String name;

    public ChatUser() {
    }

    public ChatUser(String name) {
        this.name = name;
        this.noUserName = name.equals("") ? "The username field is empty!" : null;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public String getNoUserName() {
        return noUserName;
    }

    public void setNoUserName(String noUserName) {
        this.noUserName = noUserName;
    }

}

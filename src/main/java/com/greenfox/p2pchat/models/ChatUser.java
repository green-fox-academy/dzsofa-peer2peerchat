package com.greenfox.p2pchat.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class ChatUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String noUserName;

    private String username;

    public ChatUser() {
    }

    public ChatUser(String username) {
        this.username = username;
        this.noUserName = username.equals("") ? "The username field is empty!" : null;

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

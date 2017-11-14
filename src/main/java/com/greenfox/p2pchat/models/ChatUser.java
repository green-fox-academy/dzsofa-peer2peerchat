package com.greenfox.p2pchat.models;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class ChatUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;
    private String name;

    public ChatUser() {
    }

    public ChatUser(String name) {
        this.name = name;
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


}

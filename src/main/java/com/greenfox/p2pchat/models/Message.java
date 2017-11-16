package com.greenfox.p2pchat.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
@Table(name = "messages")
public class Message {

    @Id
    private int id;
    private String text;
    private String username;
    private Timestamp timestamp;

    public Message(String text, String username) {
        this.text = text;
        this.username = username;
        this.id = (int) (1000000 + Math.random() * 999999);
        this.timestamp = new Timestamp(System.currentTimeMillis());
    }

    public Message() {
        this.id = (int) (1000000 + Math.random() * 999999);
        this.timestamp = new Timestamp(System.currentTimeMillis());

    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

}

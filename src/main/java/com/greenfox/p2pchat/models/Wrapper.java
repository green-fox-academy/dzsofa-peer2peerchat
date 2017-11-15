package com.greenfox.p2pchat.models;

public class Wrapper {
    private Message message;
    private Client client;


    public Wrapper(Message message, Client client) {
        this.message = message;
        this.client = client;
    }

    public Wrapper() {
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

}

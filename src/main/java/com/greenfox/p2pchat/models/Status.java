package com.greenfox.p2pchat.models;

import com.fasterxml.jackson.annotation.JsonInclude;

public class Status {
    private String status;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String message;

    public Status(String status, String message) {
        this.status = status;
        this.message = message;
    }

    public Status(String status) {
        this.status = status;
    }

    public Status() {
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

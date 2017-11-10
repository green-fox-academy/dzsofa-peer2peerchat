package com.greenfox.p2pchat.models;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Log {
    String createdAt;
    String logLevel;
    String endpoint;
    String method;
    String request;


    public Log() {
    }

    public Log(HttpServletRequest request){
        this.createdAt = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS"));
        this.logLevel = System.getenv("CHAT_APP_LOGLEVEL");
        this.endpoint = request.getServletPath();
        this.method = request.getMethod();
        this.request = request.getQueryString();
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getLogLevel() {
        return logLevel;
    }

    public void setLogLevel(String logLevel) {
        this.logLevel = logLevel;
    }

    public String getEndpoint() {
        return endpoint;
    }

    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getRequest() {
        return request;
    }

    public void setRequest(String request) {
        this.request = request;
    }

    public String getLog() {
        StringBuilder sb = new StringBuilder();
        sb.append(createdAt).append(" ")
                .append(logLevel).append(" ")
                .append(endpoint).append(" ")
                .append(method).append(" ")
                .append(request);
        return sb.toString();
    }
}

package com.greenfox.p2pchat.services;

import com.greenfox.p2pchat.models.Log;
import com.greenfox.p2pchat.repositories.LogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class LogService {

    public Log getLog(HttpServletRequest request) {
        return new Log(request);
    }



}

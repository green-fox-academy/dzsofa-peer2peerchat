package com.greenfox.p2pchat.services;

import com.greenfox.p2pchat.models.Log;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class LogService {

    public Log getLog(HttpServletRequest request) {
        return new Log(request);
    }

}

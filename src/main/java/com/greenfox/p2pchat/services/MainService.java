package com.greenfox.p2pchat.services;

import com.greenfox.p2pchat.models.Log;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class MainService {

    public boolean isInfo() {
        if (System.getenv("CHAT_APP_LOGLEVEL").equals("INFO")) {
            return true;
        } else {
            return false;
        }
    }

    public void printLog(HttpServletRequest request) {
        if (isInfo()) {
            System.out.println(new Log(request).getLog());
        } else {
            System.err.println(new Log(request).getLog());
        }
    }

}

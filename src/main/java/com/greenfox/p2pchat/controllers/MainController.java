package com.greenfox.p2pchat.controllers;

import com.greenfox.p2pchat.models.Log;
import com.greenfox.p2pchat.services.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class MainController {

    @Autowired
    LogService logService;

    @GetMapping("/")
    public String heading(HttpServletRequest request) {
        if (System.getenv("CHAT_APP_LOGLEVEL").equals("INFO")) {
            System.out.println(new Log(request).getLog());
        } else if (System.getenv("CHAT_APP_LOGLEVEL").equals("ERROR")) {
            System.err.println(new Log(request).getLog());
        }
        return "index";
    }

    @GetMapping("/enter")
    public String enter() {
        return "enter";
    }

}
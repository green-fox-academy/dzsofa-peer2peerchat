package com.greenfox.p2pchat.controllers;

import com.greenfox.p2pchat.models.Log;
import com.greenfox.p2pchat.services.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@Controller
public class MainController {

    @Autowired
    LogService logService;

    @GetMapping("/")
    public String heading(HttpServletRequest request) { ;
        System.out.println(new Log(request).getLog());
        return "index";
    }

}

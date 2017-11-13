package com.greenfox.p2pchat.controllers;

import com.greenfox.p2pchat.models.Log;
import com.greenfox.p2pchat.models.Error;
import com.greenfox.p2pchat.repositories.ChatUserRepository;
import com.greenfox.p2pchat.services.LogService;
import com.greenfox.p2pchat.services.MainService;
import com.greenfox.p2pchat.services.ChatUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class MainController {

    @Autowired
    LogService logService;

    @Autowired
    ChatUserService chatUserService;

    @Autowired
    MainService mainService;

    @GetMapping("/")
    public String heading(HttpServletRequest request) {
        mainService.printLog(request);
        return "index";
    }

    @GetMapping("/enter")
    public String enter(HttpServletRequest request) {
        mainService.printLog(request);
        return "enter";
    }

    @GetMapping("enter/add")
    public String addUserName(@RequestParam String name, Error error, HttpServletRequest request) {
        mainService.printLog(request);
        if (name.equals("")) {
            error.setMessage("The username field is empty");
            return "redirect:/enter";
        } else chatUserService.save(name);
        return "redirect:/index";
    }

}
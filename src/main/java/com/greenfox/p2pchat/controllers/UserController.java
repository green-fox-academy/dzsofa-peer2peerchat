package com.greenfox.p2pchat.controllers;

import com.greenfox.p2pchat.models.ChatUser;
import com.greenfox.p2pchat.services.ChatUserService;
import com.greenfox.p2pchat.services.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class UserController {

    @Autowired
    MainService mainService;

    @Autowired
    ChatUserService chatUserService;

    @GetMapping("/enter")
    public String enter(Model model, HttpServletRequest request) {
        model.addAttribute("newUser", new ChatUser());
        mainService.printLog(request);
        return "enter";
    }

    @PostMapping("enter/add")
    public String addUserName(@ModelAttribute ChatUser user, HttpServletRequest request) {
        mainService.printLog(request);
        if (user.getUsername().equals("") || user.getUsername().equals(null)) {
            return "redirect:/enter";
        } else
            chatUserService.save(user);
        return "redirect:/";
    }

    @PostMapping("/update")
    public String updateUser(@ModelAttribute ChatUser user) {
        chatUserService.save(user);
        return "redirect:/";
    }
}

package com.greenfox.p2pchat.controllers;

import com.greenfox.p2pchat.models.ChatUser;
import com.greenfox.p2pchat.models.Message;
import com.greenfox.p2pchat.services.LogService;
import com.greenfox.p2pchat.services.MainService;
import com.greenfox.p2pchat.services.ChatUserService;
import com.greenfox.p2pchat.services.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
public class MainController {
//    private static final Logger logger =
//            Logger.getLogger(MainController.class.getName());


    @Autowired
    LogService logService;

    @Autowired
    ChatUserService chatUserService;

    @Autowired
    MainService mainService;

    @Autowired
    MessageService messageService;

    @GetMapping("/")
    public String heading(HttpServletRequest request, Model model) {
        ChatUser activeUser = chatUserService.findActive();
        mainService.printLog(request);
        if (chatUserService.hasEntry()) {
            model.addAttribute("activeUser", activeUser);
            model.addAttribute("messages", messageService.listAllMessages());
            model.addAttribute("newMessage", new Message());
            return "index";
        } else return "redirect:/enter";
    }

    @PostMapping("/addmessage")
    public String postMessage(@ModelAttribute Message message, HttpServletRequest request) {
        mainService.printLog(request);
        messageService.save(message);
        return "redirect:/";
    }

    @GetMapping("/enter")
    public String enter(Model model, HttpServletRequest request) {
        model.addAttribute("newUser", new ChatUser());
        mainService.printLog(request);
        return "enter";
    }

    @PostMapping("enter/add")
    public String addUserName(@ModelAttribute ChatUser user, HttpServletRequest request, Model model) {
        mainService.printLog(request);
        if (user.getName().equals("") || user.getName().equals(null)) {
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
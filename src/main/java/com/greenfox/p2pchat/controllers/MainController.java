package com.greenfox.p2pchat.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @GetMapping("/")
    public String heading() {
        return "Peer to Peer Chat App";
    }
}

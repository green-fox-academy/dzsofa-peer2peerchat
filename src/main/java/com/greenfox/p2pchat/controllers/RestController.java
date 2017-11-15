package com.greenfox.p2pchat.controllers;

import com.greenfox.p2pchat.models.Wrapper;
import com.greenfox.p2pchat.models.Status;
import com.greenfox.p2pchat.services.MainService;
import com.greenfox.p2pchat.services.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@org.springframework.web.bind.annotation.RestController
public class RestController {

    @Autowired
    MessageService messageService;

    @Autowired
    MainService mainService;

    @CrossOrigin("*")
    @PostMapping("/api/message/receive")
    public ResponseEntity getMessage(@RequestBody Wrapper wrapper, HttpServletRequest request   ) {
        mainService.printLog(request);
        if (wrapper.getMessage().getTimestamp() == null || wrapper.getMessage().getText() == null || wrapper.getMessage().getUsername() == null || wrapper.getClient().getId() == null) {
            return new ResponseEntity(new Status("error", "Missing field(s)"), HttpStatus.UNAUTHORIZED);
        } else {
            messageService.save(wrapper.getMessage());
            return new ResponseEntity(new Status("ok"), HttpStatus.OK);
        }
    }


}

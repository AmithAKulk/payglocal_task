package com.payglocaltask.login_task_security_jwt.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class Home {

    @RequestMapping("/welcome")
    public String welcome() {
        String text = "This is a private page.\n";
        text += "This page is not allowed for unauthenticated users.";
        return text;
    }

    @RequestMapping("/getusers")
    public String getUser() {
        return "{\"name\":\"Amith\"}";
    }
}

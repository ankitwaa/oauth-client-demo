package com.example.oauthclientdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class OAuthDemoController {

    @GetMapping("/")
    public String hell(){
        return "main.html";
    }
}

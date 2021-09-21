package com.example.oauthclientdemo.controller;

import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.OAuth2AccessToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class OAuthDemoController {

    @GetMapping("/")
    public String hell(OAuth2AuthenticationToken token){
        // We can logged in user details using - OAuth2AuthenticationToken
        System.out.println(token.getPrincipal());
        return "main.html";
    }
}

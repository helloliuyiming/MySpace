package me.lym.myspace.core.uims.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "auth")
public class AuthController {

    @GetMapping(value = "publicKey")
    public String publicKey(){
        return "this is publicKey";
    }

}

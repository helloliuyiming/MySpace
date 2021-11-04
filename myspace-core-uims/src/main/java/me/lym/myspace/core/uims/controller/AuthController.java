package me.lym.myspace.core.uims.controller;

import me.lym.myspace.core.uims.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "auth")
public class AuthController {

    @Autowired
    private TestService testService;

    @GetMapping(value = "publicKey")
    public String publicKey(){
        testService.doSomething();
        return "this is publicKey";
    }

}

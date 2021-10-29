package me.lym.myspace.core.runtime.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "meta/kafka")
public class KafkaAccessController {

    @GetMapping
    public String applyForUse(){
        return "";
    }

    @DeleteMapping
    public String release(){
        return "success";
    }

    @GetMapping(value = "config")
    public String getConfig(){
        return "";
    }


}

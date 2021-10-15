package me.lym.myspace.core.uims.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "token")
@Api("token-management")
public class TokenController {

    @GetMapping(value = "anonymous")
    @ApiOperation("getAnonymousToken")
    public String anonymous(){
        return "{'id':anonymous}";
    }
}

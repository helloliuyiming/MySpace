package me.lym.myspace.core.uims.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import me.lym.myspace.core.uims.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "token")
@Api("token-management")
public class TokenController {

    @Autowired
    TestService testService;

    @GetMapping(value = "anonymous")
    @ApiOperation("getAnonymousToken")
    public String anonymous(){
        testService.doSomething();
        return "{'id':anonymous}";
    }

    @GetMapping(value = "domain")
    @SentinelResource
    public String domain(@RequestParam String ip) {
        return ip;
    }
}

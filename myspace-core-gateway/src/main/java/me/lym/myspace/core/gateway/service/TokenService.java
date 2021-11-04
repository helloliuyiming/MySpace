package me.lym.myspace.core.gateway.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "uims-management")
public interface TokenService {

    @GetMapping(value = "/token/anonymous")
    String getAnonymousToken();

    @GetMapping(value = "/token/domain")
    String getTokenByIp(@RequestParam(value = "ip") String ip);
}

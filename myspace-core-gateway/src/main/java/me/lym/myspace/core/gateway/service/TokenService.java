package me.lym.myspace.core.gateway.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "uims-management")
public interface TokenService {

    @GetMapping(value = "/token/anonymous")
    String getAnonymousToken();
}

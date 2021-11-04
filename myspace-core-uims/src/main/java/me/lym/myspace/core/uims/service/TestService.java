package me.lym.myspace.core.uims.service;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.stereotype.Service;

@Service
public class TestService {

    @SentinelResource
    public String doSomething(){
        return "do";
    }
}

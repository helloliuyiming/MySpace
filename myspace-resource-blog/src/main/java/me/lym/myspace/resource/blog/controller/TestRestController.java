package me.lym.myspace.resource.blog.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(value = "test")
public class TestRestController {

    @Value("${testApolloValue}")
    String testApolloValue = "";

    @GetMapping(value = "testApollo")
    public String testApollo(HttpServletRequest request){
        String token = request.getHeader("token");
        System.out.println("token = " + token);
        return "testApolloValue:"+testApolloValue;
    }

}

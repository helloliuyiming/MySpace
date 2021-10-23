package me.lym.myspace.resource.blog.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.hystrix.contrib.javanica.cache.annotation.CacheResult;
import com.netflix.hystrix.exception.HystrixTimeoutException;
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
    @CacheResult
    @HystrixCommand(fallbackMethod = "fallbackMethod",
    commandProperties = {
            @HystrixProperty(name = "execution.isolation.strategy",value = "SEMAPHORE"),
            @HystrixProperty(name = "execution.isolation.semaphore.maxConcurrentRequests",value = "2"),
            @HystrixProperty(name = "circuitBreaker.forceOpen",value = "true")
    },
    ignoreExceptions = {
            HystrixTimeoutException.class,NumberFormatException.class
    })
    public String testApollo(HttpServletRequest request) throws InterruptedException {
        System.out.println(Thread.currentThread().getId());
        String token = request.getHeader("token");
        System.out.println("token = " + token);

        Thread.sleep(3000);

        System.out.println(Thread.currentThread().getId());
        return "testApolloValue:"+testApolloValue;
    }

    public String fallbackMethod(HttpServletRequest request,Throwable throwable){
        if (throwable != null) {
            throwable.printStackTrace();
        }
        System.out.println("fallbackMethod:"+Thread.currentThread().getId());
        return "fallbackMethod()";
    }
}

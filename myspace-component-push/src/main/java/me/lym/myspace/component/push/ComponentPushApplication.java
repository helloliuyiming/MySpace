package me.lym.myspace.component.push;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ComponentPushApplication {

    public static void main(String[] args) {
        SpringApplication.run(ComponentPushApplication.class,args);
    }
}

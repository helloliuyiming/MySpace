package me.lym.myspace.app.social;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@EnableApolloConfig
public class AppSocialApplication {

    public static void main(String[] args) {
        SpringApplication.run(AppSocialApplication.class,args);
    }
}

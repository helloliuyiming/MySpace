package me.lym.myspace.extension.open;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@EnableApolloConfig
public class OpenApplication {

    public static void main(String[] args) {
        SpringApplication.run(OpenApplication.class,args);
    }
}

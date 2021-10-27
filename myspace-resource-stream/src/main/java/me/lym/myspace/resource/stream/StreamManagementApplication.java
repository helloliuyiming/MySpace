package me.lym.myspace.resource.stream;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableApolloConfig
@EnableDiscoveryClient
public class StreamManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(StreamManagementApplication.class,args);
    }
}

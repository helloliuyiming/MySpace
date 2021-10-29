package me.lym.myspace.core.runtime;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableApolloConfig
@EnableDiscoveryClient
public class MySpaceRuntimeApplication {

    public static void main(String[] args) {
        SpringApplication.run(MySpaceRuntimeApplication.class,args);
    }
}

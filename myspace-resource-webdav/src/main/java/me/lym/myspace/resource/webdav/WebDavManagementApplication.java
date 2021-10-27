package me.lym.myspace.resource.webdav;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableApolloConfig
public class WebDavManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebDavManagementApplication.class,args);
    }
}

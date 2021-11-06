package me.lym.myspace.core.uims;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
@EnableAuthorizationServer
@MapperScan(basePackages = "me.lym.myspace.core.uims.dao")
public class UIMSApplication {

    public static void main(String[] args) {
        SpringApplication.run(UIMSApplication.class,args);
    }
}

package me.lym.myspace.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("me.lym.myspace.mapper")
public class MybatisPlusConfig {

}

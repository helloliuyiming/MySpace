package me.lym.myspace.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
/**
 * @author lym
 * @version 1.0
 * @date 2021/1/24 18:20
 */
@Configuration
@MapperScan("me.lym.myspace.mapper")
public class MybatisPlusConfig {

}

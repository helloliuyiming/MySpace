package me.lym.myspace;

import me.lym.myspace.mapper.BlogMapper;
import me.lym.myspace.service.BlogService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@MapperScan("me.lym.myspace.mapper")
@RunWith(SpringRunner.class)
public class MyspaceApplicationTests {

    @Autowired(required = false)
    BlogMapper blogMapper;

    BlogService blogService;

    @Test
    public void contextLoads() {
    }

    @Test
    public void testMybatisPlus(){
        System.out.println("==================testMybatisPlus()==================");
        System.out.println(blogMapper);
        System.out.println(blogMapper.selectList(null));
        
    }

}

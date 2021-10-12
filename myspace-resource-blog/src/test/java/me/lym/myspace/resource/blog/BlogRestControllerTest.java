package me.lym.myspace.resource.blog;

import com.google.gson.Gson;
import me.lym.myspace.resource.blog.entity.Blog;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultHandler;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.client.RestTemplate;
import springfox.documentation.spring.web.json.Json;

import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
public class BlogRestControllerTest {

    @Autowired
    MockMvc mockMvc;

    private final RestTemplate restTemplate = new RestTemplate();


    Gson gson = new Gson();
    private final String baseUrl = "http://localhost:8800/blog";


    @Test
    public void testNewBlog() throws Exception {

        Blog blog = new Blog();
        blog.setContent("test Blog content");
        blog.setLikes(1000L);
        blog.setTitle("test Title");
        blog.setCreateDate(new Date());

        final ResponseEntity<Blog> blogResponseEntity = restTemplate.postForEntity(baseUrl, blog, Blog.class, "");

//        System.out.println(gson.toJson(blog));
//        mockMvc.perform(MockMvcRequestBuilders.post(URI.create(baseUrl)).content(gson.toJson(blog)).contentType(MediaType.APPLICATION_JSON))
//                .andDo(MockMvcResultHandlers.print())
//                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testGetBlogByID() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get(baseUrl + "/1"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}

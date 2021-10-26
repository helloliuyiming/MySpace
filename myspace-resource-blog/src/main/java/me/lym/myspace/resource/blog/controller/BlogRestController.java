package me.lym.myspace.resource.blog.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.ribbon.proxy.annotation.Hystrix;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import me.lym.myspace.resource.blog.entity.Blog;
import me.lym.myspace.resource.blog.repository.BlogRepository;
import me.lym.myspace.resource.blog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(value = "blog")
@Slf4j
@Api(tags = "Blog-Management API")
public class BlogRestController {

    @Autowired
    private BlogService blogService;


    @PostMapping
    @ApiOperation(value = "新建blog")
    @HystrixCommand(commandProperties = {
    })
    public Blog newBlog(@RequestBody Blog blog) {
        log.info("BlogRestController.newBlog");
        return blogService.newBlog(blog);
    }

    @PatchMapping
    @HystrixCommand
    public Blog update(@RequestBody Blog blog) {
        return blogService.updateById(blog);
    }

    @GetMapping(value = "{id}")
    public Blog getById(@PathVariable(value = "id") String id) {
        System.out.println("BlogRestController.getById");
        final Blog one = blogService.findById(id);
        return one;
    }

    @DeleteMapping(value = "{id}")
    public String deleteById(@PathVariable(value = "id") String id) {
        blogService.deleteById(id);
        return "success";
    }

}

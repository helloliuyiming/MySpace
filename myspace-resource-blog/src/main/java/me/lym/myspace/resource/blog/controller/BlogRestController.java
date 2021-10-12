package me.lym.myspace.resource.blog.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import me.lym.myspace.resource.blog.entity.Blog;
import me.lym.myspace.resource.blog.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping(value = "blog")
@Api(tags = "Blog-Management API")
public class BlogRestController {

    @Autowired
    private BlogRepository blogRepository;


    @PostMapping
    @ApiOperation(value = "新建blog")
    public Blog newBlog(@RequestBody Blog blog) {
        System.out.println("BlogRestController.newBlog");
        blogRepository.save(blog);
        return blog;
    }

    @PatchMapping()
    public Blog update(@RequestBody Blog blog) {
//        blogRepository.update(blog);
        return blog;
    }

    @GetMapping(value = "{id}")
    public Blog getById(@PathVariable(value = "id") Integer id) {
        System.out.println("BlogRestController.getById");
        final Blog one = blogRepository.getOne(id);
        return one;
    }

    @DeleteMapping(value = "{id}")
    public String deleteById(@PathVariable(value = "id") Integer id) {
        blogRepository.deleteById(id);
        return "success";
    }
}

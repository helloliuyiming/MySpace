package me.lym.myspace.app.controller.restful;

import me.lym.myspace.app.pojo.Blog;
import me.lym.myspace.app.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * @author lym
 * @version 1.0
 * @date 2021/1/24 18:20
 */
@RestController
@RequestMapping("blog")
public class BlogRestController {

    @Autowired
    private BlogService blogService;

    @RequestMapping("test")
    public ResponseEntity<String> test(){
        Blog blog = new Blog();
        blog.setContent("test Blog Content");
        blog.setCreateDate(new Date());
//        blog.setId(UUID.randomUUID().toString());
        blog.setStatus("open");
        blog.setTitle("test blog title");

        return ResponseEntity.ok("success");
    }

    @PostMapping
    public ResponseEntity<String> newBlog(){
        return ResponseEntity.ok("new访问成功，但未保存成功，因为未实现此功能");
    }

    @DeleteMapping
    public ResponseEntity<String> delBlog(){
        return ResponseEntity.ok("del访问成功，但未保存成功，因为未实现此功能");
    }

    @RequestMapping(method = {RequestMethod.PATCH,RequestMethod.PUT})
    public ResponseEntity<String> updateBlog(){
        return ResponseEntity.ok("modify访问成功，但未保存成功，因为未实现此功能");
    }

    @GetMapping
    public ResponseEntity<String> queryBlog(){
        return ResponseEntity.ok("共查询："+ 1 +"条数据");
    }
}

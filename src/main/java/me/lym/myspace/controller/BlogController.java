package me.lym.myspace.controller;

import me.lym.myspace.pojo.Blog;
import me.lym.myspace.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * @author lym
 * @version 1.0
 * @date 2021/1/24 18:20
 */
@Controller
public class BlogController {
    @Autowired
    private BlogService blogService;


}

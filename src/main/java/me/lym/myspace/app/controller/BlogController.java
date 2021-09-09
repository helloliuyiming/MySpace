package me.lym.myspace.app.controller;

import me.lym.myspace.app.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

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

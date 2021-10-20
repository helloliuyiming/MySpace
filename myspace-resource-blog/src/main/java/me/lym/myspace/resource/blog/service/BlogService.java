package me.lym.myspace.resource.blog.service;

import me.lym.myspace.resource.blog.entity.Blog;

import java.util.List;

public interface BlogService {

    Blog newBlog(Blog blog);

    Blog updateById(Blog blog);

    void deleteById(String blogId);

    List<Blog> list();

    Blog findById(String blogId);
}

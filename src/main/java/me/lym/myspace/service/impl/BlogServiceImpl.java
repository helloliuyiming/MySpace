package me.lym.myspace.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import me.lym.myspace.mapper.BlogMapper;
import me.lym.myspace.pojo.Blog;
import me.lym.myspace.service.BlogService;
import org.springframework.stereotype.Component;
/**
 * @author lym
 * @version 1.0
 * @date 2021/1/24 18:20
 */
@Component
public class BlogServiceImpl extends ServiceImpl<BlogMapper,Blog> implements BlogService {

}

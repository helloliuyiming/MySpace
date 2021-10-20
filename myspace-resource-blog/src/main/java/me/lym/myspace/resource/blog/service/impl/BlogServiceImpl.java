package me.lym.myspace.resource.blog.service.impl;

import me.lym.myspace.resource.blog.entity.Blog;
import me.lym.myspace.resource.blog.repository.BlogRepository;
import me.lym.myspace.resource.blog.service.BlogService;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFutureCallback;

import java.util.List;

@Component
public class BlogServiceImpl implements BlogService {

    @Autowired
    private BlogRepository blogRepository;

    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;

    @Override
    public Blog newBlog(Blog blog) {
        blogRepository.save(blog);
        ProducerRecord<String, String> producerRecord = new ProducerRecord<>("new_resource_publish", "blog", String.valueOf(blog.getId()));
        kafkaTemplate.send(producerRecord).addCallback(new ListenableFutureCallback<SendResult<String, String>>() {
            @Override
            public void onFailure(Throwable ex) {
                ex.printStackTrace();
            }

            @Override
            public void onSuccess(SendResult<String, String> result) {

            }
        });
        return blog;
    }

    @Override
    public Blog updateById(Blog blog) {
        return blogRepository.save(blog);
    }

    @Override
    public void deleteById(String blogId) {
        blogRepository.deleteById(Integer.valueOf(blogId));
    }

    @Override
    public List<Blog> list() {
        return blogRepository.findAll();
    }

    @Override
    public Blog findById(String blogId) {
        return blogRepository.getOne(Integer.valueOf(blogId));
    }
}

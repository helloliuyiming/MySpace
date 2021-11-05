package me.lym.myspace.core.uims.controller;

import io.swagger.annotations.Api;
import me.lym.myspace.core.uims.dao.UserDao;
import me.lym.myspace.core.uims.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "ac/user")
@Api(tags = "UserController")
public class UserController {

    @Autowired
    UserDao userDao;

    @PostMapping
    public User newUser(@RequestBody User user) {
        user.setId(userDao.newUser(user));
        return user;
    }

    @GetMapping(value = "list")
    public List<User> list(Integer limit, Integer offset) {
        if (limit == null || limit < 1) {
            limit = 20;
        }
        if (offset == null) {
            offset = 0;
        }
        return userDao.queryWithPage(limit,offset);
    }

    @GetMapping("{id}")
    public User queryById(@PathVariable(value = "id") Integer id) {
        return userDao.queryById(id);
    }

    @DeleteMapping("{id}")
    public void deleteById(@PathVariable(value = "id") Integer id) {
        userDao.deleteById(id);
    }

    @GetMapping(value = "group/{id}")
    public List<User> queryByGroupId(@PathVariable("id") Integer id) {
        return userDao.queryByGroupId(id);
    }
}

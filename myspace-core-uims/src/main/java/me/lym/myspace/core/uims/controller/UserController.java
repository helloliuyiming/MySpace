package me.lym.myspace.core.uims.controller;

import io.swagger.annotations.Api;
import me.lym.myspace.core.uims.entity.User;
import me.lym.myspace.core.uims.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "ac/user")
@Api(tags = "UserController")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping
    public User newUser(@RequestBody User user) {
        userService.createUser(user);
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
        return userService.queryWithPage(limit,offset);
    }

    @GetMapping("{id}")
    public User queryById(@PathVariable(value = "id") String id) {
        return userService.queryById(id);
    }

    @DeleteMapping("{id}")
    public void deleteById(@PathVariable(value = "id") String id) {
        userService.deleteById(id);
    }

    @GetMapping(value = "group/{id}")
    public List<User> queryByGroupId(@PathVariable("id") String id) {
        return userService.queryByGroupId(id);
    }
}

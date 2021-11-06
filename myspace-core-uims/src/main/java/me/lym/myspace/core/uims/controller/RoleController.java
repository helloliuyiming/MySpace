package me.lym.myspace.core.uims.controller;

import me.lym.myspace.core.uims.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "register/role")
public class RoleController {

    @Autowired
    private RoleService roleService;


}

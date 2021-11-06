package me.lym.myspace.core.uims.controller;

import io.swagger.annotations.Api;
import me.lym.myspace.common.util.ResponseBox;
import me.lym.myspace.core.uims.entity.dto.AuthorizationConfigDTO;
import me.lym.myspace.core.uims.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "register/permission")
@Api(tags = "注册权限信息")
public class PermissionController {

    @Autowired
    private PermissionService permissionService;

    @PostMapping(value = "config")
    public ResponseBox config(@RequestBody AuthorizationConfigDTO authorizationConfigDTO) {
        return ResponseBox.ok();
    }


}

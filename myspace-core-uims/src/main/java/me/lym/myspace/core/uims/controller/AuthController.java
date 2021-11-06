package me.lym.myspace.core.uims.controller;

import me.lym.myspace.common.util.ResponseBox;
import me.lym.myspace.core.uims.entity.dto.ApplyAuthorizationDTO;
import me.lym.myspace.core.uims.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "auth")
public class AuthController {

    @PostMapping(value = "apply")
    public ResponseBox<String> applyAccessAuthorization(@RequestBody ApplyAuthorizationDTO applyAuthorizationDTO){
        return ResponseBox.ok("ok");
    }
}

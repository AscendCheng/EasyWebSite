package com.website.video.controller;

import com.website.video.domain.User;
import com.website.video.utils.JsonResult;
import com.website.video.utils.JwtUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {
    @PostMapping("/register")
    public JsonResult register(@RequestBody User user) {
        String token = JwtUtils.generateWebToken(user);
        return JsonResult.success(token);
    }
}

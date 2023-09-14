package com.jieun.velog.controller;

import com.jieun.velog.model.Login;
import com.jieun.velog.model.User;
import com.jieun.velog.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;


    @PostMapping("/login")
    public Login login(@RequestBody User user) {
        return userService.getUserByEmailAndPwd(user.getEmail(), user.getPwd());
    }

    @PostMapping("/duplicate-email-check")
    public boolean duplicateEmailCheck(@RequestBody User user) {
        return userService.duplicateEmailCheck(user.getEmail());
    }

}

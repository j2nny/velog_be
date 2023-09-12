package com.jieun.velog.controller;

import com.jieun.velog.auth.jwt.JwtProvider;
import com.jieun.velog.model.Login;
import com.jieun.velog.model.User;
import com.jieun.velog.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final JwtProvider jwtProvider;

    @GetMapping("/login")
    public Login loginUser(@RequestBody User user) {
        User userData = userService.getUserByLoginIdAndPwd(user.getLoginId(), user.getPwd());

        Login login = new Login();
        login.setUser(userData);
        login.setToken(jwtProvider.generateToken(userData));

        return login;
    }
}

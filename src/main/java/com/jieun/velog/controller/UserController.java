package com.jieun.velog.controller;

import com.jieun.velog.auth.jwt.JwtProvider;
import com.jieun.velog.model.Login;
import com.jieun.velog.model.User;
import com.jieun.velog.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final JwtProvider jwtProvider;

    @PostMapping("/login")
    public Login loginUser(@RequestBody User user) {
        User userData = userService.getUserByLoginIdAndPwd(user.getEmail(), user.getPwd());

        Login login = new Login();
        login.setUser(userData);
        login.setToken(jwtProvider.generateToken(userData));

        return login;
    }
}

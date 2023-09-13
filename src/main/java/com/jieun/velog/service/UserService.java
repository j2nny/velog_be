package com.jieun.velog.service;

import com.jieun.velog.auth.jwt.JwtProvider;
import com.jieun.velog.mapper.UserMapper;
import com.jieun.velog.model.Login;
import com.jieun.velog.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserMapper userMapper;
    private final JwtProvider jwtProvider;

    public Login getUserByLoginIdAndPwd(String email, String pwd){

        Login login = new Login();
        User user = userMapper.findByLoginIdAndPwd(email, pwd);

        if(user != null) {
            login.setUser(user);
            login.setToken(jwtProvider.generateToken(user));
            login.setMessage("valid");
        } else {
            login.setMessage("invalid");
        }

        return login;
    }
}

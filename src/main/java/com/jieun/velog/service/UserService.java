package com.jieun.velog.service;

import com.jieun.velog.mapper.UserMapper;
import com.jieun.velog.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserMapper userMapper;

    public User getUserByLoginIdAndPwd(String email, String pwd){
        return userMapper.findByLoginIdAndPwd(email, pwd);
    }
}

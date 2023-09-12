package com.jieun.velog.mapper;

import com.jieun.velog.model.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    public User findByLoginIdAndPwd(String loginId, String pwd);
}

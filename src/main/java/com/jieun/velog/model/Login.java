package com.jieun.velog.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Login {

    //회원 정보
    User user;

    //토큰
    String token;
}

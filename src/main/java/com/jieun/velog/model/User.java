package com.jieun.velog.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class User extends BaseObject {
    //회원번호
    Integer userNo;

    //회원로그인ID
    String loginId;

    //이메일
    String email;

    //이름
    String name;

    //비밀번호
    String pwd;

    //회원등급
    String grade;

    //프로필이미지경로
    String profileImgPath;
}

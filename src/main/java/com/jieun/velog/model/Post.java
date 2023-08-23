package com.jieun.velog.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Post extends BaseObject {

    //게시물번호
    private Integer postNo;

    //제목
    private String title;

    //내용
    private String content;

    //썸네일이미지경로
    private String thumbnailImgPath;

    //태그
    private String tag;

    //공개여부
    private String opnpubYn;

    //URL
    private String url;

    //시리즈
    private String series;

    //게시물설명
    private String explnCntnt;
}

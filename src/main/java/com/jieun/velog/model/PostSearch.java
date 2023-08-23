package com.jieun.velog.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostSearch {

    //검색어
    private String searchWord;

    //검색 기간 시작일
    private String searchStartDate;

    //검색 기간 종료일
    private String searchEndDate;
}

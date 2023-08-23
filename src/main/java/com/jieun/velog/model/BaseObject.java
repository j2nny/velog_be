package com.jieun.velog.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BaseObject {

    //등록일시
    private String regDttm;

    //등록사용자ID
    private String regUserId;

    //최종수정일시
    private String lastModDttm;

    //최종수정사용자ID
    private String lastModUserId;

}

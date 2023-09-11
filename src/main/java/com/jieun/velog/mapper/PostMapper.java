package com.jieun.velog.mapper;

import com.jieun.velog.model.Post;
import com.jieun.velog.model.PostSearch;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PostMapper {
    /*
        게시물 목록 조회
    */
    List<Post> getPostList(PostSearch postSearch);

    /*
        게시물 개수 조회
    */
    Integer getPostListCount(PostSearch postSearch);

    /*
        게시물 단건 조회
     */
    Post getPost(int postNo);
}

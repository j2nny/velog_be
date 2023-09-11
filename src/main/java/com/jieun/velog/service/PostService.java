package com.jieun.velog.service;

import com.jieun.velog.mapper.PostMapper;
import com.jieun.velog.model.Post;
import com.jieun.velog.model.PostSearch;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostMapper postMapper;

    /*
        게시물 목록 조회
     */
    public List<Post> getPostList(PostSearch postSearch){
        int postListCount = postMapper.getPostListCount(postSearch);

        return postListCount > 0 ? postMapper.getPostList(postSearch) : Collections.emptyList();
    }

    /*
        게시물 단건 조회
    */
    public Post getPost(int postNo){
        return postMapper.getPost(postNo);
    }
}

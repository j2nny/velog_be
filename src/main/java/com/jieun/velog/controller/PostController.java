package com.jieun.velog.controller;

import com.jieun.velog.model.Post;
import com.jieun.velog.model.PostSearch;
import com.jieun.velog.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/posts")
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    /*
        게시물 목록 조회
     */
    @GetMapping("")
    public List<Post> getPostList(PostSearch postSearch) {
        return postService.getPostList(postSearch);
    }
}

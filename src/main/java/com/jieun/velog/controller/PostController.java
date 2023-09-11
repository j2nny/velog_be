package com.jieun.velog.controller;

import com.jieun.velog.model.Post;
import com.jieun.velog.model.PostSearch;
import com.jieun.velog.service.PostService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/posts")
@RequiredArgsConstructor
@Slf4j
public class PostController {
    private final PostService postService;

    /*
        게시물 목록 조회
     */
    @GetMapping("")
    public List<Post> getPostList(PostSearch postSearch) {
        log.info("게시물 목록 조회");
        return postService.getPostList(postSearch);
    }

    /*
        게시물 단건 조회
     */
    @GetMapping("/{postNo}")
    public Post getPost(@PathVariable("postNo") int postNo) {
        log.info("게시물 단건 조회");
        return postService.getPost(postNo);
    }
}

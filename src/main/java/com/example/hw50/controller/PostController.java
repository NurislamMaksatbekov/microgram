package com.example.hw50.controller;

import com.example.hw50.entity.Post;
import com.example.hw50.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    @GetMapping("/getusersposts")
    public List<Post> selectPost(@RequestParam Long id){
        return postService.selectPost(id);
    }

    @GetMapping("/selectpostbyfollowers")
    public List<Post> selectPostByFollowers(@RequestParam Long id){
        return postService.selectPostByFollowers(id);
    }

}

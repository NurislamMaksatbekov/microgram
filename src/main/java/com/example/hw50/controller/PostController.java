package com.example.hw50.controller;

import com.example.hw50.dto.PostDto;
import com.example.hw50.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/posts")
public class PostController {
    private final PostService postService;

    @GetMapping("/getusersposts")
    public List<PostDto> selectPost(@RequestParam Long id) {
        return postService.selectPost(id);
    }

    @GetMapping("/selectpostbyfollowers")
    public List<PostDto> selectPostByFollowers(@RequestParam Long id) {
        return postService.selectPostByFollowers(id);
    }

    @CrossOrigin(origins = "http://localhost:63342")
    @GetMapping("/showPosts")
    public List<PostDto> showPosts(){
        return postService.showPosts();
    }
}
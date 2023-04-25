package com.example.hw50.controller;

import com.example.hw50.dto.CommentDto;
import com.example.hw50.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/comments")
public class CommentController {
    private final CommentService commentService;

    @GetMapping("/postComment")
    @CrossOrigin(origins = "http://localhost:63342")
    public List<CommentDto> showComments(@RequestParam Long postId){
        return commentService.showComments(postId);
    }
}

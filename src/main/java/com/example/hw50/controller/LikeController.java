package com.example.hw50.controller;

import com.example.hw50.dto.LikeDto;
import com.example.hw50.entity.Like;
import com.example.hw50.service.LikeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/likes")
public class LikeController {
    private final LikeService likeService;

    @GetMapping("/isliked")
    public LikeDto isLiked(@RequestParam Long userId, Long postId){
        return likeService.isLiked(userId, postId);
    }
}

package com.example.hw50.service;

import com.example.hw50.dao.LikeDao;
import com.example.hw50.entity.Like;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LikeService {
    private final LikeDao likeDao;

    public Optional<Like> isLiked(Long userId, Long postId){
        return likeDao.isLiked(userId, postId);
    }

}

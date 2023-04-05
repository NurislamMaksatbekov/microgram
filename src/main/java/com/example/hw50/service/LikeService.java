package com.example.hw50.service;

import com.example.hw50.dao.LikeDao;
import com.example.hw50.dto.LikeDto;
import com.example.hw50.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class LikeService {
    private final LikeDao likeDao;

    public LikeDto isLiked(Long userId, Long postId){
        var like = likeDao.isLiked(userId, postId)
                .orElseThrow(() -> new ResourceNotFoundException("This user doesn't like that post!"));
        return LikeDto.from(like);
    }

}

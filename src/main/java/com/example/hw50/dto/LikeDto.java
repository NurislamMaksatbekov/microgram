package com.example.hw50.dto;

import com.example.hw50.entity.Like;
import lombok.*;

@Data
@Builder(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
public class LikeDto {
    public static LikeDto from(Like like){
        return builder()
                .userId(like.getUserId())
                .postId(like.getPostId())
                .timeOfLike(like.getTimeOfLike())
                .build();
    }

    private Long userId;
    private Long postId;
    private Integer timeOfLike;
}

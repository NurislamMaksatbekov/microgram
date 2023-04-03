package com.example.hw50.dto;

import com.example.hw50.entity.Post;
import lombok.*;

@Data
@Builder(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
public class PostDto {
    public static PostDto from(Post post){
        return builder()
                .image(post.getImage())
                .description(post.getDescription())
                .timeOfPublication(post.getTimeOfPublication())
                .userId(post.getUserId())
                .build();
    }

    private String image;
    private String description;
    private Integer timeOfPublication;
    private Long userId;
}

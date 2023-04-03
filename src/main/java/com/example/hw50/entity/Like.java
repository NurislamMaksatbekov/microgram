package com.example.hw50.entity;

import com.example.hw50.util.Generator;
import lombok.*;

import java.util.Random;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Like {

    private Long id;
    private Long user;
    private Long post;
    private Integer timeOfLike;

    public static Like random(){
        Integer rnd = new Random().nextInt(29) + 1;
        Integer r = new Random().nextInt(29) + 1;
        Long userId = Long.valueOf(rnd);
        Long postId = Long.valueOf(r);
        return builder()
                .user(userId)
                .post(postId)
                .timeOfLike(Generator.makeYear())
                .build();

    }
}

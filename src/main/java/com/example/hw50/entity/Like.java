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
    private Long userId;
    private Long postId;
    private Integer timeOfLike;

    public static Like random(){
        Integer rnd = new Random().nextInt(7) + 1;
        Integer r = new Random().nextInt(7) + 1;
        Long userId = Long.valueOf(rnd);
        Long postId = Long.valueOf(r);
        return builder()
                .userId(userId)
                .postId(postId)
                .timeOfLike(Generator.makeYear())
                .build();

    }
}


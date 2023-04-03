package com.example.hw50.entity;

import com.example.hw50.util.Generator;
import lombok.*;

import java.util.Random;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Comment {

    private Long id;
    private String textOfComment;
    private Integer timeOfComment;
    private Long userId;
    private Long postId;

    public static Comment random(){
        Integer rnd = new Random().nextInt(29) + 1;
        Integer r = new Random().nextInt(29) + 1;
        Long userId = Long.valueOf(rnd);
        Long postId = Long.valueOf(r);
        return builder()
                .textOfComment(Generator.makeDescription())
                .timeOfComment(Generator.makeYear())
                .userId(userId)
                .postId(postId)
                .build();
    }


}
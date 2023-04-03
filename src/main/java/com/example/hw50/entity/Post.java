package com.example.hw50.entity;

import com.example.hw50.util.Generator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.Random;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Post {

    private Long id;
    private String image;
    private String description;
    private Integer timeOfPublication;

    @JsonProperty("user_id")
    private Long userId;

    public static Post random(){
        Integer rnd = new Random().nextInt(29) + 1;
        Long id = Long.valueOf(rnd);
        return builder()
                .image(Generator.makeDescription())
                .description(Generator.makeDescription())
                .timeOfPublication(Generator.makeYear())
                .userId(id)
                .build();
    }
}

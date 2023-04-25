package com.example.hw50.entity;

import com.example.hw50.util.Generator;
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
    private Long userId;

    public static Post random(){
        Integer rnd = new Random().nextInt(7) + 1;
        Long id = Long.valueOf(rnd);
        return builder()
                .image("https://toppeoples.ru/wp-content/uploads/2021/03/Le3mpmWeD0w.jpg")
                .description(Generator.makeDescription())
                .timeOfPublication(Generator.makeYear())
                .userId(id)
                .build();
    }
}

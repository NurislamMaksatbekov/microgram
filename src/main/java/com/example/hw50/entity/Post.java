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
                .image("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSlros2f-2PIRzeI3-1FYsdqiyeRZHAy5MFfw&usqp=CAU")
                .description(Generator.makeDescription())
                .timeOfPublication(Generator.makeYear())
                .userId(id)
                .build();
    }
}

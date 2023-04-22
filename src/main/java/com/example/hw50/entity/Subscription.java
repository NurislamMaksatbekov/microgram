package com.example.hw50.entity;

import com.example.hw50.util.Generator;
import lombok.*;

import java.util.Random;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Subscription {

    private Long id;
    private Long followers;
    private Long following;
    private Integer timeOfEvent;

    public static Subscription random(){
        Integer rnd = new Random().nextInt(7) + 1;
        Integer r = new Random().nextInt(7) + 1;
        Long followers_id = Long.valueOf(rnd);
        Long following_id = Long.valueOf(r);

        return builder()
                .followers(followers_id)
                .following(following_id)
                .timeOfEvent(Generator.makeYear())
                .build();
    }
}
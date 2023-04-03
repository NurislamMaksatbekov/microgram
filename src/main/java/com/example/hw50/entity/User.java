package com.example.hw50.entity;

import com.example.hw50.util.Generator;
import lombok.*;

import java.util.Random;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
    public class User {

    private Long id;
    private String naame;
    private String username;
    private String email;
    private String password;
    private int publications;
    private int followings;
    private int followers;

    public static User random(){
        Random rnd = new Random();
        return builder()
                .naame(Generator.makeName())
                .username(Generator.makeName())
                .email(Generator.makeEmail())
                .password("qwerty0")
                .publications(rnd.nextInt(9))
                .followings(rnd.nextInt(29) + 1)
                .followers(rnd.nextInt(29) +1)
                .build();
    }
}

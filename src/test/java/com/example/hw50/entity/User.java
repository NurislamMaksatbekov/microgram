package com.example.hw50.entity;

import lombok.*;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private int id;
    private String name;
    private String userName;
    private String email;
    private String password;
    private int publications;
    private int followings;
    private int followers;
}

package com.example.hw50.entity;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Subscription {
    private int id;
    private User user;
    private Post post;
    private Integer timeOfLike;

}

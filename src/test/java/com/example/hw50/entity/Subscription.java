package com.example.hw50.entity;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Subscription {

    private int id;
    private User followers;
    private User following;
    private Integer timeOfEvent;

}

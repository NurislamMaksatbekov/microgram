package com.example.hw50.entity;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Post {
    private int id;
    private String image;
    private String description;
    private Integer timeOfPublication;
}

package com.example.hw50.entity;

import lombok.*;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Comment {
    private int id;
    private String textOfComment;
    private Integer timeOfComment;

}
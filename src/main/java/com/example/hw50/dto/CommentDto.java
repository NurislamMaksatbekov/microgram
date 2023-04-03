package com.example.hw50.dto;

import com.example.hw50.entity.Comment;
import lombok.*;

@Data
@Builder(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
public class CommentDto {
    public static CommentDto from(Comment comment){
        return builder()
                .textOfComment(comment.getTextOfComment())
                .timeOfComment(comment.getTimeOfComment())
                .userId(comment.getUserId())
                .postId(comment.getPostId())
                .build();
    }

    private String textOfComment;
    private Integer timeOfComment;
    private Long userId;
    private Long postId;
}

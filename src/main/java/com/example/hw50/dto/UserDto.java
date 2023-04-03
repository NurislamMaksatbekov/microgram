package com.example.hw50.dto;

import com.example.hw50.entity.User;
import lombok.*;

@Data
@Builder(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
public class UserDto {
    public static UserDto from(User user){
        return builder()
                .naame(user.getNaame())
                .username(user.getUsername())
                .followings(user.getFollowings())
                .followers(user.getFollowers())
                .build();
    }

    private String naame;
    private String username;
    private int followings;
    private int followers;
}

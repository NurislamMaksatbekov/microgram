package com.example.hw50.dto;

import com.example.hw50.entity.Subscription;
import lombok.*;

@Data
@Builder(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
public class SubscriptionDto {
    public static SubscriptionDto from(Subscription subscription){
        return builder()
                .followings(subscription.getFollowing())
                .followers(subscription.getFollowers())
                .timeOfEvent(subscription.getTimeOfEvent())
                .build();
    }

    private Long followings;
    private Long followers;
    private Integer timeOfEvent;

}

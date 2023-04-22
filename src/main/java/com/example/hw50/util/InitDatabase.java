package com.example.hw50.util;

import com.example.hw50.dao.*;
import com.example.hw50.entity.*;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

@Configuration
@RequiredArgsConstructor
public class InitDatabase {

    @Bean
    CommandLineRunner init(CommentDao commentDao, LikeDao likeDao, PostDao postDao, SubscriptionDao subscriptionDao, UserDao userDao) {
        return (args) -> {
            userDao.createTable();
            postDao.createTable();
            likeDao.createTable();
            subscriptionDao.createTable();
            commentDao.createTable();

            List<User> users = Stream.generate(User::random)
                    .limit(7)
                    .collect(toList());
            userDao.saveAll(users);

            List<Post> posts = Stream.generate(Post::random)
                    .limit(7)
                    .collect(toList());
            postDao.saveAll(posts);

            List<Subscription> subscriptions = Stream.generate(Subscription::random)
                    .limit(7)
                    .collect(toList());
            subscriptionDao.saveAll(subscriptions);

            List<Like> likes = Stream.generate(Like::random)
                    .limit(7)
                    .collect(toList());
            likeDao.saveAll(likes);

            List<Comment> comments = Stream.generate(Comment::random)
                    .limit(7)
                    .collect(toList());
            commentDao.saveAll(comments);

        };
    }
}

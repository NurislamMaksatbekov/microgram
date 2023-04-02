package com.example.hw50.util;

import com.example.hw50.dao.*;
import com.example.hw50.entity.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

@Configuration
public class InitDatabase {

    private static final Random r = new Random();

    @Bean
    CommandLineRunner init(CommentDao commentDao, LikeDao likeDao, PostDao postDao, SubscriptionDao subscriptionDao, UserDao userDao) {
        return (args) -> {
            userDao.createTable();
            likeDao.createTable();
            postDao.createTable();
            subscriptionDao.createTable();
            commentDao.createTable();

//            List<User> users = Stream.generate(User::random)
//                    .limit(10)
//                    .collect(toList());
//            userDao.saveAll(users);
//
//            List<Post> posts = Stream.generate(Post::random)
//                    .limit(10)
//                    .collect(toList());
//            postDao.saveAll(posts);
//
//            List<Subscription> subscriptions = Stream.generate(Post::random)
//                    .limit(10)
//                    .collect(toList());
//            subscriptionDao.saveAll(subscriptions);
//
//            List<Like> likes = Stream.generate(Post::random)
//                    .limit(10)
//                    .collect(toList());
//            likeDao.saveAll(likes);
//            List<Comment> comments = Stream.generate(Post::random)
//                    .limit(10)
//                    .collect(toList());
//            commentDao.saveAll(comments);

        };
    }
}

package com.example.hw50.dao;

import com.example.hw50.entity.Post;
import com.example.hw50.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class LikeDao {
    private final JdbcTemplate jdbcTemplate;

    public void createTable(){
        jdbcTemplate.execute("create table if not exist liked_post" +
                "   (id bigserial primary key," +
                "   timeoflike data," +
                "   user_id bigint not null references usr (id)" +
                "   post_id bigint not null references post (id));");
    }

}

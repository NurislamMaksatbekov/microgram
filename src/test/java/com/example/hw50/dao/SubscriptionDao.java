package com.example.hw50.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class SubscriptionDao {
    private final JdbcTemplate jdbcTemplate;

    public void createTable(){
        jdbcTemplate.execute("create table if not exist subscription " +
                "   (id bigserial primary key," +
                "   timeofevent data," +
                "   followers_id bigint not null references usr (id)," +
                "   following_id bigint not null references user (id));");
    }
}

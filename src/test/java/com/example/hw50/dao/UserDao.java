package com.example.hw50.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserDao {
    private final JdbcTemplate jdbcTemplate;

    public void createTable() {
        jdbcTemplate.execute("create table if not exists usr" +
                "   (id bigserial primary key," +
                "   name text not null," +
                "   username text not null unique," +
                "   email text not null unique," +
                "   password text not null ," +
                "   publication bigint default 0," +
                "   followers bigint default 0," +
                "   followings bigint default 0," +
                ");");
    }

}

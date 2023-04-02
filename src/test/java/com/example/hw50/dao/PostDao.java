package com.example.hw50.dao;


import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PostDao {
    private final JdbcTemplate jdbcTemplate;

    public void createTable(){
        jdbcTemplate.execute("create table if not exists post\n" +
                "   (id bigserial primary key," +
                "   image text," +
                "   description text," +
                "   time_of_publication data," +
                "   user_id bigint not null references usr(id));");
    }

}

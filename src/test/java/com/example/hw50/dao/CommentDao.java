package com.example.hw50.dao;


import com.example.hw50.entity.Comment;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@Component
@RequiredArgsConstructor
public class CommentDao {
    private final JdbcTemplate jdbcTemplate;

    public void createTable() {
        jdbcTemplate.execute("create table if not exists comment" +
                "   (id bigserial primary key," +
                "   text_of_comment text," +
                "   time_of_comment date," +
                "   comment_id bigint not null references comment (id)," +
                "   post_id bigint not null references post (id));");
    }

    public void saveAll(List<Comment> comments) {
        String sql = "insert into comment(textofcomment, timeofcomment) " +
                "values(?,?)";

        jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                ps.setString(1, comments.get(i).getTextOfComment());
                ps.setInt(2, comments.get(i).getTimeOfComment());
            }

            @Override
            public int getBatchSize() {
                return comments.size();
            }
        });
    }

}

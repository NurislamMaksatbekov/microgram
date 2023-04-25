package com.example.hw50.dao;


import com.example.hw50.entity.Comment;
import com.example.hw50.entity.Post;
import com.example.hw50.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class CommentDao {
    private final JdbcTemplate jdbcTemplate;

    public void createTable() {
        jdbcTemplate.execute("create table if not exists comment" +
                "   (id bigserial primary key," +
                "   text_of_comment text," +
                "   time_of_comment int," +
                "   user_id bigint not null references usr (id)," +
                "   post_id bigint not null references post (id));");
    }

    public List<Comment> showComments(Long id){
        String sql = "select * " +
                "from comment " +
                "where post_id = ?";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Comment.class), id);
    }

    public void saveAll(List<Comment> comments) {
        String sql = "insert into comment(text_of_comment, time_of_comment, user_id, post_id) " +
                "values(?,?,?,?)";

        jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                ps.setString(1, comments.get(i).getTextOfComment());
                ps.setInt(2, comments.get(i).getTimeOfComment());
                ps.setLong(3, comments.get(i).getUserId());
                ps.setLong(4, comments.get(i).getPostId());
            }

            @Override
            public int getBatchSize() {
                return comments.size();
            }
        });
    }

}

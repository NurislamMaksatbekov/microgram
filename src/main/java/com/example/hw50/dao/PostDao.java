package com.example.hw50.dao;


import com.example.hw50.entity.Post;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@Component
@RequiredArgsConstructor
public class PostDao {
    private final JdbcTemplate jdbcTemplate;

    public void createTable(){
        jdbcTemplate.execute("create table if not exists post\n" +
                "   (id bigserial primary key," +
                "   image text not null," +
                "   description text," +
                "   time_of_publication int," +
                "   user_id bigint not null references usr(id));");
    }

    public void saveAll(List<Post> posts) {
        String sql = "insert into post(image, description, time_of_publication, user_id) " +
                "values(?,?,?,?)";

        jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                ps.setString(1, posts.get(i).getImage());
                ps.setString(2, posts.get(i).getDescription());
                ps.setInt(3, posts.get(i).getTimeOfPublication());
                ps.setLong(4, posts.get(i).getUserId());
            }

            public int getBatchSize() {
                return posts.size();
            }
        });
    }

    public List<Post> selectPost(Long id){
        String sql = "select *" +
                " from post p" +
                " where user_id = ?";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Post.class), id);
    }

    public List<Post> selectPostByFollowers(Long id){
        String sql = "select *" +
                " from post p" +
                " where user_id IN " +
                "(select following_id " +
                "from subscription " +
                "where following_id = ?);";
                return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Post.class), id);
    }
}

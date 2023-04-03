package com.example.hw50.dao;

import com.example.hw50.entity.Like;
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
public class LikeDao {
    private final JdbcTemplate jdbcTemplate;

    public void createTable(){
        jdbcTemplate.execute("create table if not exists liked_post" +
                "   (id bigserial primary key," +
                "   time_of_like int," +
                "   user_id bigint not null references usr (id)," +
                "   post_id bigint not null  references post (id));");
    }

    public void saveAll(List<Like> likes) {
        String sql = "insert into liked_post(time_of_like, user_id, post_id) " +
                "values(?,?,?)";

        jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                ps.setInt(1, likes.get(i).getTimeOfLike());
                ps.setLong(2, likes.get(i).getUserId());
                ps.setLong(3, likes.get(i).getPostId());
            }

            public int getBatchSize() {
                return likes.size();
            }
        });
    }

    public Optional<Like> isLiked(Long userId, Long postId){
        String sql = "select l.id  " +
                "from liked_post l " +
                "where user_id = ? " +
                "and post_id = ?;";
        return Optional.ofNullable(DataAccessUtils.singleResult(
                jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Like.class), userId, postId)
        ));
    }

}

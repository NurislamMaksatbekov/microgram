package com.example.hw50.dao;

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
public class UserDao {
    private final JdbcTemplate jdbcTemplate;


    public void createTable() {
        jdbcTemplate.update("create table if not exists usr" +
                "   (id bigserial primary key," +
                "   naame text not null," +
                "   username text not null unique," +
                "   email text not null unique," +
                "   password text not null ," +
                "   publication bigint default 0," +
                "   followers bigint default 0," +
                "   followings bigint default 0);");
    }

    public void saveAll(List<User> users) {
        String sql = "insert into usr(naame, username, email, password, publication, followers, followings) " +
                "values(?,?,?,?,?,?,?)";

        jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                ps.setString(1, users.get(i).getNaame());
                ps.setString(2, users.get(i).getUsername());
                ps.setString(3, users.get(i).getEmail());
                ps.setString(4, users.get(i).getPassword());
                ps.setInt(5, users.get(i).getPublications());
                ps.setInt(6, users.get(i).getFollowers());
                ps.setInt(7, users.get(i).getFollowings());

            }

            public int getBatchSize() {
                return users.size();
            }
        });
    }

    public Optional<User> findByName(String name) {
        String sql = "select * " +
                "from usr " +
                "where naame = ?";
        return Optional.ofNullable(DataAccessUtils.singleResult(
                jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class), name)
        ));
    }

    public Optional<User> findByUsername(String username) {
        String sql = "select * " +
                "from usr " +
                "where username = ?";
        return Optional.ofNullable(DataAccessUtils.singleResult(
                jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class), username)
        ));
    }


    public Optional<User> findByEmail(String email) {
        String sql = "select * " +
                "from usr " +
                "where email = ?";
        return Optional.ofNullable(DataAccessUtils.singleResult(
                jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class), email)
        ));
    }

    public Optional<User> ifUserExist(String email) {
        String sql = "select email " +
                "from usr " +
                "where email = ?";
        return Optional.ofNullable(DataAccessUtils.singleResult(
                jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class), email)
        ));
    }
}

package com.example.hw50.dao;

import com.example.hw50.entity.Subscription;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;


@Component
@RequiredArgsConstructor
public class SubscriptionDao {
    private final JdbcTemplate jdbcTemplate;

    public void createTable(){
        jdbcTemplate.execute("create table if not exists subscription " +
                "   (id bigserial primary key," +
                "   time_of_event int," +
                "   followers_id bigint not null references usr (id)," +
                "   following_id bigint not null references usr (id));");
    }



    public void saveAll(List<Subscription> subscriptions) {
        String sql = "insert into subscription(time_of_event, followers_id, following_id) " +
                "values(?,?,?)";

        jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                ps.setInt(1, subscriptions.get(i).getTimeOfEvent());
                ps.setLong(2, subscriptions.get(i).getFollowers());
                ps.setLong(3, subscriptions.get(i).getFollowing());
            }

            public int getBatchSize() {
                return subscriptions.size();
            }
        });
    }
}

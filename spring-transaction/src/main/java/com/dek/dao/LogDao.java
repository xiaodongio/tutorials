package com.dek.dao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class LogDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void add(String content) {
        System.out.println("LogDao add....");
        String sql = "insert into t_log(content) values (?);";
        int update = jdbcTemplate.update(sql, content);
        System.out.println("insert result " + update);
    }

}

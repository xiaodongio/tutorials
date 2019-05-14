package com.dek.dao;

import com.dek.utils.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void add(String name, Integer age) {
		System.out.println("userDao add....");
		String sql = "insert into user(id, name, age) values (?, ?, ?);";
		int update = jdbcTemplate.update(sql, UUIDUtil.getId(), name, age);
		System.out.println("insert result " + update);
	}

}

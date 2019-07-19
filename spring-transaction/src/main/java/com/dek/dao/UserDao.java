package com.dek.dao;

import com.dek.entity.User;
import com.dek.utils.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.security.SecureRandom;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

	public void testData(int rows) {
		SecureRandom secureRandom = new SecureRandom();

		String sql = "insert into t_user (name, age) values (?, ?);";
		jdbcTemplate.batchUpdate(sql,new BatchPreparedStatementSetter() {

			@Override
			public int getBatchSize() {
				return rows;
			}
			@Override
			public void setValues(PreparedStatement ps, int i)
					throws SQLException {
				ps.setString(1, getRandomString(secureRandom, 8));
				ps.setInt(2, secureRandom.nextInt(100));
			}
		});
	}

	private static String getRandomString(SecureRandom secureRandom, int length){
		String str="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		StringBuffer sb=new StringBuffer();
		for(int i=0;i<length;i++){
			int number=secureRandom.nextInt(62);
			sb.append(str.charAt(number));
		}
		return sb.toString();
	}

}

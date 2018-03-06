package com.elifnur.springexample.dao.jdbcimpl.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.elifnur.springexample.model.User;

public class UserRowMapper implements RowMapper<User> {

	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
	   User user=new User();
	   user.setId(rs.getInt("id"));
	   user.setUsername(rs.getString("username"));
	   user.setName(rs.getString("name"));
	   user.setSurname(rs.getString("surname"));
		return user;
	}

}

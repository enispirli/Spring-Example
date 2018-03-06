package com.elifnur.springexample.dao.jdbcimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;


import com.elifnur.springexample.dao.UserDAO;
import com.elifnur.springexample.dao.jdbcimpl.mapper.UserRowMapper;
import com.elifnur.springexample.model.User;
@Repository
public class UserJDBCImpl implements UserDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public User create(User user) {
		final String sql = "insert into user(username,name,surname) values (?,?,?)";
		KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(new PreparedStatementCreator() {

			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement preparedStatement = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
				preparedStatement.setString(1, user.getUsername());
				preparedStatement.setString(2, user.getName());
				preparedStatement.setString(3, user.getSurname());
				return preparedStatement;
			}
		}, keyHolder);

		int newUserId = keyHolder.getKey().intValue();
		user.setId(newUserId);
		return user;
	}

	@Override
	public void delete(int id) {
		final String sql = "Delete from user where id=?";
		jdbcTemplate.update(new PreparedStatementCreator() {

			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement preparedStatement = con.prepareStatement(sql);
				preparedStatement.setInt(1, id);
				return preparedStatement;
			}
		});
	}

	@Override
	public void update(User user) {
		final String sql = "update user set username=?, name=?, surname=? where id=?";
		jdbcTemplate.update(new PreparedStatementCreator() {

			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement preparedStatement = con.prepareStatement(sql);
				preparedStatement.setString(1, user.getUsername());
				preparedStatement.setString(2, user.getName());
				preparedStatement.setString(3, user.getSurname());
				preparedStatement.setInt(4, user.getId());
				return preparedStatement;
			}
		});
	}

	@Override
	public List<User> getAll() {
		
		return jdbcTemplate.query("select * from user", new UserRowMapper());
	}

}

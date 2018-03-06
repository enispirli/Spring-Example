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

import com.elifnur.springexample.dao.CommentDAO;
import com.elifnur.springexample.dao.jdbcimpl.mapper.CommentRowMapper;
import com.elifnur.springexample.model.Comment;
@Repository
public class CommentJDBCImpl implements CommentDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public Comment create(Comment com) {
		final String sql = "insert into comment(text,userid,postid) values(?,?,?)";
		KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(new PreparedStatementCreator() {

			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement preparedStatement = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
				preparedStatement.setString(1, com.getText());
			    preparedStatement.setInt(2, com.getUserId());
				preparedStatement.setInt(3, com.getPostId());
				return preparedStatement;
			}
		}, keyHolder);

		int newComId = keyHolder.getKey().intValue();
		com.setId(newComId);
		return com;
	}

	
	@Override
	public void delete(int id) {
		final String sql = "Delete from comment where id=?";
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
	public void update(Comment com) {
		final String sql = "update comment set text=?  where id=?";
		jdbcTemplate.update(new PreparedStatementCreator() {

			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement preparedStatement = con.prepareStatement(sql);
				preparedStatement.setString(1, com.getText());
				preparedStatement.setInt(2, com.getId());
				return preparedStatement;
			}
		});

		
	}

	@Override
	public List<Comment> getAll() {
		return jdbcTemplate.query("select * from comment", new CommentRowMapper());
	}

}

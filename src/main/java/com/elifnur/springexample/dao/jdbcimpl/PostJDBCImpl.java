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
import com.elifnur.springexample.dao.PostDAO;
import com.elifnur.springexample.dao.jdbcimpl.mapper.PostRowMapper;
import com.elifnur.springexample.model.Post;


@Repository
public class PostJDBCImpl implements PostDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public Post create(Post post) {
		final String sql = "insert into post(title,text,categoryid,userid) values(?,?,?,?)";
		KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(new PreparedStatementCreator() {

			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement preparedStatement = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
				preparedStatement.setString(1, post.getTitle());
				preparedStatement.setString(2, post.getText());
				preparedStatement.setInt(3, post.getCategoryId());
				preparedStatement.setInt(4, post.getUserId());
				return preparedStatement;
			}
		}, keyHolder);

		int newPostId = keyHolder.getKey().intValue();
		post.setId(newPostId);
		return post;
	}

	@Override
	public void delete(int id) {
		final String sql = "Delete from post where id=?";
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
	public void update(Post post) {
		final String sql = "update post set title=?, text=? where id=?";
		jdbcTemplate.update(new PreparedStatementCreator() {

			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement preparedStatement = con.prepareStatement(sql);
				preparedStatement.setString(1,post.getTitle());
				preparedStatement.setString(2, post.getText());
				preparedStatement.setInt(3, post.getId());
				return preparedStatement;
			}
		});

	}

	@Override
	public List<Post> getAll() {
		return jdbcTemplate.query("select * from post", new PostRowMapper());
	}

	@Override
	public Post getById(int id) {
		return jdbcTemplate.queryForObject("select * from post where id=?", new Object[]{id},new PostRowMapper());
	}

	@Override
	public List<Post> getUserPosts(int userid) {
		
		return jdbcTemplate.query("select * from post where userid=?", new Object[]{userid}, new PostRowMapper());
	}

}

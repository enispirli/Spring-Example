package com.elifnur.springexample.dao.jdbcimpl.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.elifnur.springexample.model.Post;

public class PostRowMapper implements RowMapper<Post> {

	@Override
	public Post mapRow(ResultSet rs, int numRow) throws SQLException {
		Post post = new Post();
		post.setId(rs.getInt("id"));
		post.setTitle(rs.getString("title"));
		post.setText(rs.getString("text"));
		post.setCategoryId(rs.getInt("categoryid"));
		post.setUserId(rs.getInt("userid"));
		return post;
	}

}

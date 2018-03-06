package com.elifnur.springexample.dao.jdbcimpl.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.elifnur.springexample.model.Comment;

public class CommentRowMapper implements RowMapper<Comment> {

	@Override
	public Comment mapRow(ResultSet rs, int num) throws SQLException {
	Comment com=new Comment();
	com.setId(rs.getInt("id"));
	com.setText(rs.getString("text"));
	com.setUserId(rs.getInt("userid"));
	com.setPostId(rs.getInt("postid"));
		return com;
	}
 
}

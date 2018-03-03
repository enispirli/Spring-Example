package com.elifnur.springexample.dao;

import java.util.List;

import com.elifnur.springexample.model.Comment;

public interface CommentDAO {

	Comment create(Comment com);
	
	void delete(Comment com);
	
	void update(Comment com);
	
	List<Comment> getAll();
	
}

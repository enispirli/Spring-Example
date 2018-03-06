package com.elifnur.springexample.dao;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.elifnur.springexample.model.Comment;

@Repository
public interface CommentDAO {

	Comment create(Comment com);
	
	void delete(int id);
	
	void update(Comment com);
	
	List<Comment> getAll();
	
}

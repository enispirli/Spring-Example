package com.elifnur.springexample.dao;

import java.util.List;

import com.elifnur.springexample.model.Post;

public interface PostDAO {

	Post create(Post post);
	
	void delete (Post post);
	
	void update(Post post);
	
	List<Post> getAll();
	
	Post getById(int id);
	
	List<Post> getUserPosts(int userId);
	
	
}

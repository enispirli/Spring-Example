package com.elifnur.springexample.dao;

import java.util.List;

import com.elifnur.springexample.model.User;

public interface UserDAO {
	
	User create(User user);
	
	void delete(User user);
	
	void update(User user);
	
	List<User> getAll();

}

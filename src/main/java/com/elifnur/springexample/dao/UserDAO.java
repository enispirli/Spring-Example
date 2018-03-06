package com.elifnur.springexample.dao;

import java.util.List;

import org.springframework.stereotype.Repository;


import com.elifnur.springexample.model.User;
@Repository
public interface UserDAO {
	
	User create(User user);
	
	void delete(int id);
	
	void update(User user);
	
	List<User> getAll();

}

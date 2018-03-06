package com.elifnur.springexample.controller;

import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.elifnur.springexample.dao.UserDAO;
import com.elifnur.springexample.model.User;

@RestController
@RequestMapping("users")
public class UserController {
	@Autowired
   private UserDAO userDAO;	

	@GetMapping("")
	Collection<User> getAll(){
		return userDAO.getAll();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	User createUser(@RequestBody User user) {
		return userDAO.create(user);
	}
	@DeleteMapping("{id}")
	void deleteUser(@PathVariable("id")int id) {
		userDAO.delete(id);
	}
	
	@PutMapping
	void uptade(@RequestBody User user) {
		userDAO.update(user);
	}
}	

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
import com.elifnur.springexample.dao.PostDAO;
import com.elifnur.springexample.model.Post;

@RestController
@RequestMapping("posts")
public class PostController {
	@Autowired
	private PostDAO postDAO;
	
	@GetMapping
	Collection<Post> getAll(){
		return postDAO.getAll();
	}
	@GetMapping("{id}")
	Post getPost(@PathVariable("id") int id) {
		return postDAO.getById(id);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	Post create(@RequestBody Post post) {
		return postDAO.create(post);
	}
	
	@DeleteMapping("{id}")
	void delete(@PathVariable("id")int id ) {
		postDAO.delete(id);
	}
	
	@PutMapping
	void update(@RequestBody Post post) {
		postDAO.update(post);
	}

	@GetMapping("users/{userid}")
	Collection<Post> getuseridPosts(@PathVariable("userid") int userid){
		return postDAO.getUserPosts(userid);
	}
}

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
import com.elifnur.springexample.dao.CommentDAO;
import com.elifnur.springexample.model.Comment;




@RestController
@RequestMapping("comments")
public class CommentController {
	@Autowired
	private CommentDAO commentDAO;
	

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	Comment create(@RequestBody Comment com) {
		return commentDAO.create(com);
	}
	
	
	@GetMapping
	Collection<Comment> getAll(){
		return commentDAO.getAll();
	}
	
	@DeleteMapping("{id}")
	void delete(@PathVariable("id")int id) {
		commentDAO.delete(id);
	}
	
	@PutMapping
	void update(@RequestBody Comment com) {
		commentDAO.update(com);
	}
	
}

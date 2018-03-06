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

import com.elifnur.springexample.dao.CategoryDAO;
import com.elifnur.springexample.model.Category;

@RestController
@RequestMapping("categories")
public class CategoryController {
	@Autowired
	private CategoryDAO categoryDAO;

	@GetMapping
	Collection<Category> getAll(){
		return categoryDAO.getAll();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	Category create(@RequestBody Category cat) {
		return categoryDAO.insert(cat);
	}
	@DeleteMapping("{id}")	
	void deleteCategory(@PathVariable("id") int id) {
		categoryDAO.delete(id);
	}
	@PutMapping
	void update(@RequestBody Category cat) {
		categoryDAO.update(cat);
	}
}

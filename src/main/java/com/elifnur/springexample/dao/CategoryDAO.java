package com.elifnur.springexample.dao;

import java.util.List;

import com.elifnur.springexample.model.Category;

public interface CategoryDAO {

	Category insert(Category cat);

	void delete(Category cat);

	void update(Category cat);

	List<Category> getAll();
}

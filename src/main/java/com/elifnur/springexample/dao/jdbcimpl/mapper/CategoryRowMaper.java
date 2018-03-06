package com.elifnur.springexample.dao.jdbcimpl.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.elifnur.springexample.model.Category;

public class CategoryRowMaper implements RowMapper<Category>{

	@Override
	public Category mapRow(ResultSet rs, int numRow) throws SQLException {
		Category cat=new Category();
		cat.setId(rs.getInt("id"));
		cat.setName(rs.getString("name"));
		return cat;
	}
	

}

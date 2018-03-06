package com.elifnur.springexample.dao.jdbcimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import com.elifnur.springexample.dao.CategoryDAO;
import com.elifnur.springexample.dao.jdbcimpl.mapper.CategoryRowMaper;
import com.elifnur.springexample.model.Category;

@Repository
public class CategoryJDBCImpl implements CategoryDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public Category insert(Category cat) {
		final String sql = "insert into category(name) values(?)";
		KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(new PreparedStatementCreator() {

			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement preparedStatement = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
				preparedStatement.setString(1, cat.getName());
				return preparedStatement;
			}
		}, keyHolder);

		int newCatId = keyHolder.getKey().intValue();
		cat.setId(newCatId);
		return cat;
	}

	@Override
	public void delete(int id) {
		final String sql = "delete from category where id=?";
		jdbcTemplate.update(new PreparedStatementCreator() {

			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement preparedStatement = con.prepareStatement(sql);
				preparedStatement.setInt(1, id);
				return preparedStatement;
			}
		});

	}

	@Override
	public void update(Category cat) {
		final String sql = "update category set  name=? where id=?";
		jdbcTemplate.update(new PreparedStatementCreator() {

			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement preparedStatement = con.prepareStatement(sql);
				preparedStatement.setString(1, cat.getName());
				preparedStatement.setInt(2, cat.getId());
				return preparedStatement;
			}
		});

	}

	@Override
	public List<Category> getAll() {

		return jdbcTemplate.query("select * from category", new CategoryRowMaper());
	}

}

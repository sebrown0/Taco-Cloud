package com.sebrown.app.repo;

import static com.sebrown.app.models.Ingredient.Type.valueOf;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.sebrown.app.models.Ingredient;

@Repository
public class JdbcIngredientRepository implements IngredientRepository{

	private final JdbcTemplate jdbcTemplate;

	public JdbcIngredientRepository(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public Iterable<Ingredient> findAll() {
		var sql = "SELECT id, name, type FROM ingredient";
		return jdbcTemplate.query(sql, this::mapRowToIngredient);
	}

	@Override
	public Optional<Ingredient> findById(String id) {
		var sql = "SELECT id, name, type FROM ingredient WHERE id=?";
		
		List<Ingredient> results = 
				jdbcTemplate.query(sql, this::mapRowToIngredient, id);
		
		return results.isEmpty() ? 
				Optional.empty() : Optional.of(results.get(0));
	}

	@Override
	public Ingredient save(Ingredient ingredient) {
		var sql = 
				"INSERT INTO ingredient (id, name, type) VALUES (?, ?, ?)";
		
	  jdbcTemplate.update(
	      sql,
	      ingredient.getId(),
	      ingredient.getName(),
	      ingredient.getType().toString());
	  
	  return ingredient;
	}
	
	private Ingredient mapRowToIngredient(
		ResultSet row, int rowNum) throws SQLException {
		
	  return new Ingredient(
	      row.getString("id"),
	      row.getString("name"),
	      valueOf(row.getString("type")));
	}
	
}

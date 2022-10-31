package com.sebrown.app.repo;

import java.util.Optional;

import com.sebrown.app.models.Ingredient;

public interface IngredientRepository {
	 
  Iterable<Ingredient> findAll();
  
  Optional<Ingredient> findById(String id);
  
  Ingredient save(Ingredient ingredient);
  
}

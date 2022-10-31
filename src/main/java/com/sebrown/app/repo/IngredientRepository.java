package com.sebrown.app.repo;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.sebrown.app.models.Ingredient;

public interface IngredientRepository  
	extends CrudRepository<Ingredient, Long>{
	   
  Optional<Ingredient> findById(String id);  
  
}

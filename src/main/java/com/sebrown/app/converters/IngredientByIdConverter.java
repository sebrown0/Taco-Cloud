package com.sebrown.app.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.sebrown.app.models.Ingredient;
import com.sebrown.app.repo.IngredientRepository;

@Component
public class IngredientByIdConverter implements 
	Converter<String, Ingredient>{

	private final IngredientRepository ingredientRepo;
	  
  public IngredientByIdConverter(IngredientRepository ingredientRepo) {
		this.ingredientRepo = ingredientRepo;
	}
  
  @Override
  public Ingredient convert(String id) {
    return ingredientRepo.findById(id).orElse(null);
  }

}

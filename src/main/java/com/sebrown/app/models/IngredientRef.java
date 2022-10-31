package com.sebrown.app.models;

import javax.persistence.Embeddable;

import lombok.Data;

@Data @Embeddable
public class IngredientRef {
	private final String ingredient;
}

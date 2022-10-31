package com.sebrown.app.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import javax.persistence.Id;

import lombok.Data;

@Data @Entity
public class Taco {
  
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
  
  private Date createdAt = new Date();
  
  @NotNull
  @Size(min=5, message="Name must be at least 5 characters long")
  private String name;
  
  @NotNull @ManyToMany()
  @Size(min=1, message="You must choose at least 1 ingredient")
  private List<Ingredient> ingredients;
  
}

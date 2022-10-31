package com.sebrown.app.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data 
@Document
public class TacoOrder implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id 
	private String id;
  
  private Date placedAt = new Date();
  
  @NotBlank(message="Delivery name is required")
  private String deliveryName;
 
  @NotBlank(message="Street is required")
  private String deliveryStreet;
 
  @NotBlank(message="City is required")
  private String deliveryCity;
 
  @NotBlank(message="State is required")
  private String deliveryState;
 
  @NotBlank(message="Zip code is required")
  private String deliveryZip;
  
  private String ccNumber;
  
  private String ccExpiration;
  
  @Digits(integer=3, fraction=0, message="Invalid CVV")
  private String ccCVV;
 
  private List<Taco> tacos = new ArrayList<>();
 
  public void addTaco(Taco taco) {
    this.tacos.add(taco);
  }
  
}

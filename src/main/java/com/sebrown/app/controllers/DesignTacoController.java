package com.sebrown.app.controllers;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.sebrown.app.models.Ingredient;
import com.sebrown.app.models.Ingredient.Type;
import com.sebrown.app.models.Taco;
import com.sebrown.app.models.TacoOrder;
import com.sebrown.app.repo.IngredientRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("design")
@SessionAttributes("tacoOrder")
public class DesignTacoController {

	private final IngredientRepository repo;
	
	public DesignTacoController(IngredientRepository repo) {		
		this.repo = repo;
	}

	@ModelAttribute
	public void addIngredientsToModel(Model model) {
		List<Ingredient> ingredients = (List<Ingredient>) repo.findAll();
			 
    Type[] types = Type.values();
    for (Type type : types) {
      model.addAttribute(type.toString().toLowerCase(),
          filterByType(ingredients, type));
    }
	 }
	 
	  @ModelAttribute(name = "tacoOrder")
	  public TacoOrder order() {
	    return new TacoOrder();
	  }
	  
	  @ModelAttribute(name = "taco")
	  public Taco taco() {
	    return new Taco();
	  }
	 
	  @GetMapping
	  public String showDesignForm() {
	    return "design";
	  }
	  
	  @PostMapping
	  public String processTaco(
	  	@Valid Taco taco, Errors errors,
	    @ModelAttribute TacoOrder tacoOrder) {
	  	
	  	if(errors.hasErrors()) {
	  		log.info(errors.getFieldError().getDefaultMessage());
	  		return "/design";
	  	}
	  	
	    tacoOrder.addTaco(taco);
	    log.info("Processing taco: {}", taco);
	   
	    return "redirect:/orders/current";
	  }
	  
	  private Iterable<Ingredient> filterByType(
	    List<Ingredient> ingredients, Type type) {
	  	
	    return 
	    		ingredients.stream()
            .filter(x -> x.getType().equals(type))
            .collect(Collectors.toList());
	  }
}

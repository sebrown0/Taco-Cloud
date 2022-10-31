package com.sebrown.app.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.sebrown.app.models.TacoOrder;
import com.sebrown.app.repo.OrderRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/orders")
@SessionAttributes("tacoOrder")
public class OrderController {

	private final OrderRepository orderRepo;
	
	public OrderController(OrderRepository orderRepository) {
		this.orderRepo = orderRepository;
	}

	@GetMapping("/current")
	public String orderForm() {
		return "orderForm";
	}
	
	@PostMapping
	public String processOrder(
		@Valid TacoOrder order, Errors errors, 
		SessionStatus sessionStatus) {

  	if(errors.hasErrors()) {
  		log.info(errors.getFieldError().getDefaultMessage());
  		return "/orderForm";
  	}
  	
	  log.info("Order submitted: {}", order);
	  orderRepo.save(order);
	  sessionStatus.setComplete();
	 
	  return "redirect:/";
	}
}

package com.sebrown.app.repo;

import org.springframework.data.repository.CrudRepository;

import com.sebrown.app.models.TacoOrder;

public interface OrderRepository extends 
	CrudRepository<TacoOrder, String> {
		
}

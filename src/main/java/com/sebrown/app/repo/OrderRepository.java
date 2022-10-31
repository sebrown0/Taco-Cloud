package com.sebrown.app.repo;

import com.sebrown.app.models.TacoOrder;

public interface OrderRepository {
	
	TacoOrder save(TacoOrder tacoOrder);
	
}

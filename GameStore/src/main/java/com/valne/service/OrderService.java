package com.valne.service;

import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;
import com.valne.entity.Order;
import com.valne.entity.Product;

public interface OrderService {

	Order create(JsonNode data);
	
	List<Order> findAll();

	Order findById(Integer id);
	

	Order create(Order Order);

	Order update(Order Order);
	
	void delete(Integer id);

	List<Order> findByUsername(String username);
}

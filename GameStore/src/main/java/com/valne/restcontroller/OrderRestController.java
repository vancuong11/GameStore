package com.valne.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.valne.entity.Order;
import com.valne.entity.OrderDetail;
import com.valne.service.OrderDetailService;
import com.valne.service.OrderService;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/orders")
public class OrderRestController {
	@Autowired
	OrderService orderService;
	@Autowired
	OrderDetailService orderDetailService;
//	luu checkout
	@PostMapping()
	public Order create(@RequestBody JsonNode data) {
		return orderService.create(data);
	}
	
	@GetMapping()
	public List<Order> getAll() {
		return orderService.findAll();
	}
	@GetMapping("{id}")
	public Order getOne(@PathVariable("id") Integer id) {
		return orderService.findById(id);
	}
	
	@PutMapping("{id}")
	public Order update(@PathVariable("id") Integer id, @RequestBody Order Order ) {
		Order.setStatus(true);
		return orderService.update(Order);
	}
	
	@DeleteMapping("{id}")
	public void update(@PathVariable("id") Integer id) {
		orderService.delete(id);
	}
}

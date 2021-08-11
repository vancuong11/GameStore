package com.valne.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.valne.entity.Order;
import com.valne.entity.OrderDetail;
import com.valne.service.OrderDetailService;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/orderdetail")
public class OderDetailRestController {
	@Autowired
	OrderDetailService OrderDetailService ;
	
	@GetMapping()
	public List<OrderDetail> getAll() {
		return OrderDetailService.findAll();
}
	@GetMapping("{id}")
	public List<OrderDetail> getOne(@PathVariable("id") Integer id) {
		return OrderDetailService.findByOrderId(id);
	}
}

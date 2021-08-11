package com.valne.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.valne.dao.OrderDetail_Dao;
import com.valne.dao.Order_Dao;
import com.valne.entity.Order;
import com.valne.entity.OrderDetail;
import com.valne.service.OrderService;
@Service
public class OrderServiceImpl implements OrderService {
	@Autowired
	Order_Dao orderDao;
	@Autowired
	OrderDetail_Dao deDao;
//	checkout

//	
	@Override
	public List<Order> findAll() {
		// TODO Auto-generated method stub
		return orderDao.findAll();
	}
	@Override
	public Order findById(Integer id) {
		// TODO Auto-generated method stub
		return orderDao.findById(id).get();
	}
	@Override
	public Order create(Order Order) {
		// TODO Auto-generated method stub
		return orderDao.save(Order);
	}
	@Override
	public Order update(Order Order) {
		// TODO Auto-generated method stub
		return orderDao.save(Order);
	}
	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		orderDao.deleteById(id);
	}
	@Override
	public List<Order> findByUsername(String username) {
		// TODO Auto-generated method stub
		return orderDao.findByUsername(username);
	}
	@Override
	public Order create(JsonNode data) {
		ObjectMapper mapper = new ObjectMapper();
		
		Order order = mapper.convertValue(data, Order.class);
		orderDao.save(order);
		
		TypeReference<List<OrderDetail>> type = new TypeReference<List<OrderDetail>>() {};
		List<OrderDetail> details = mapper.convertValue(data.get("orderDetails"), type)
				.stream().peek(d->d.setOrder(order)).collect(Collectors.toList());
		deDao.saveAll(details);
		return order;
	}
	
	
	
	

}

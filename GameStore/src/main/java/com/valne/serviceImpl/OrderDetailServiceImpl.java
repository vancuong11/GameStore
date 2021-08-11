package com.valne.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.valne.dao.OrderDetail_Dao;
import com.valne.entity.OrderDetail;
import com.valne.service.OrderDetailService;
@Service
public class OrderDetailServiceImpl implements OrderDetailService {
	@Autowired
	OrderDetail_Dao dao;
	@Override
	public List<OrderDetail> findAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}
	@Override
	public OrderDetail findById(Integer id) {
		// TODO Auto-generated method stub
		return dao.findById(id).get();
	}
	@Override
	public List<OrderDetail> findByOrderId(Integer id) {
		// TODO Auto-generated method stub
		return dao.findByOrderId(id);
	}

}

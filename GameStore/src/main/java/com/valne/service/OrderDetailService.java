package com.valne.service;

import java.util.List;

import com.valne.entity.OrderDetail;

public interface OrderDetailService {

	List<OrderDetail> findAll();

	OrderDetail findById(Integer id);

	List<OrderDetail> findByOrderId(Integer id);

}

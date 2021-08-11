package com.valne.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.valne.entity.OrderDetail;

public interface OrderDetail_Dao extends JpaRepository<OrderDetail, Integer> {
	@Query("select p from OrderDetail p where p.order.id = ?1")
	List<OrderDetail> findByOrderId(Integer id);

}

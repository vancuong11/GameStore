package com.valne.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.valne.entity.Order;

public interface Order_Dao extends JpaRepository<Order, Integer> {
	@Query("select p from Order p where p.account.username =?1 order by p.id desc")
	List<Order> findByUsername(String username);

}

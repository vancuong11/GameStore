package com.valne.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.valne.entity.Product;

public interface Product_Dao extends JpaRepository<Product, Integer> {
	@Query("Select o From Product o Where o.category.id =?1")
	List<Product> findByCategoriId(Integer cid);
	
	@Query("SELECT p FROM Product p WHERE p.name LIKE ?1")
	Page<Product> findByKeywords(String keywords, Pageable pageable);
}

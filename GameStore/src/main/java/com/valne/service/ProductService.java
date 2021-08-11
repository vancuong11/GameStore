package com.valne.service;

import java.util.List;

import com.valne.entity.Product;

public interface ProductService {

	List<Product> findAll();

	Product findById(Integer id);
	
	List<Product> findByCategoryId(Integer cid);

	Product create(Product product);

	Product update(Product product);

	void delete(Integer id);

}

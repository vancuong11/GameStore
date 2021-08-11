package com.valne.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.valne.dao.Product_Dao;
import com.valne.entity.Product;
import com.valne.service.ProductService;
@Service
public class ProductServiceImpl implements ProductService{
	@Autowired
	Product_Dao dao;
	@Override
	public List<Product> findAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}
	@Override
	public Product findById(Integer id) {
		// TODO Auto-generated method stub
		return dao.findById(id).get();
	}
	@Override
	public List<Product> findByCategoryId(Integer cid) {
		// TODO Auto-generated method stub
		return dao.findByCategoriId(cid);
	}
	@Override
	public Product create(Product product) {
		// TODO Auto-generated method stub
		return dao.save(product);
	}
	@Override
	public Product update(Product product) {
		// TODO Auto-generated method stub
		return dao.save(product);
	}
	@Override
	public void delete(Integer id) {
		dao.deleteById(id);
	}
	
}

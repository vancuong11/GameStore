package com.valne.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.valne.dao.Categori_Dao;
import com.valne.entity.Category;
import com.valne.service.CategoryService;
@Service
public class CategoryServiceImpl implements CategoryService {
	@Autowired
	Categori_Dao dao;
	@Override
	public List<Category> findAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}
	@Override
	public Category create(Category category) {
		// TODO Auto-generated method stub
		return dao.save(category);
	}
	@Override
	public Category update(Category category) {
		// TODO Auto-generated method stub
		return dao.save(category);
	}
	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		dao.deleteById(id);
	}
	@Override
	public Category findById(Integer id) {
		// TODO Auto-generated method stub
		return dao.findById(id).get();
	}

}

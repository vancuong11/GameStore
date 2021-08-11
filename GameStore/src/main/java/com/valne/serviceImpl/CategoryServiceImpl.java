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

}

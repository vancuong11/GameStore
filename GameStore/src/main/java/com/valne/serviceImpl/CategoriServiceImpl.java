package com.valne.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.valne.dao.Categori_Dao;
import com.valne.entity.Category;
import com.valne.service.CategoriService;

@Service
public class CategoriServiceImpl implements CategoriService {
	@Autowired
	Categori_Dao dao;
	@Override
	public List<Category> findAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

}

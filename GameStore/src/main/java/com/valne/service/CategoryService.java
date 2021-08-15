package com.valne.service;

import java.util.List;

import com.valne.entity.Category;

public interface CategoryService {

	List<Category> findAll();

	Category create(Category category);

	Category update(Category category);

	void delete(Integer id);

	Category findById(Integer id);

}

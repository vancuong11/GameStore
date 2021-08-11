package com.valne.service;

import java.util.List;

import com.valne.entity.Authority;

public interface AuthoritiService {
	List<Authority> findAuthoritiesOfAdministrators();

	List<Authority> findAll();

	Authority create(Authority auth);

	void delete(Integer id);
}

package com.valne.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.valne.dao.Account_Dao;

import com.valne.dao.Authority_Dao;
import com.valne.entity.Account;
import com.valne.entity.Authority;
import com.valne.service.AuthoritiService;

@Service
public class AuthorityServiceImpl implements AuthoritiService {
	@Autowired
	Authority_Dao dao;
	@Autowired
	Account_Dao accdao;
	
	@Override
	public List<Authority> findAuthoritiesOfAdministrators() {
		List<Account> accounts = accdao.getAdministrators();
		return dao.authoritiesOf(accounts);
	}

	@Override
	public List<Authority> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Authority create(Authority auth) {
		// TODO Auto-generated method stub
		return dao.save(auth);
	}

	@Override
	public void delete(Integer id) {
		dao.deleteById(id);
		
	}


}

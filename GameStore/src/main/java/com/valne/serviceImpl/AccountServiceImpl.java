package com.valne.serviceImpl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.valne.dao.Account_Dao;
import com.valne.entity.Account;
import com.valne.service.AccountService;
@Service
public class AccountServiceImpl implements AccountService {
//	tiem bean
	@Autowired
	Account_Dao dao;
	@Autowired
	HttpServletRequest request;
	@Override
	public Account findById(String username) {
		return dao.findById(username).get();
	}
	@Override
	public Account save(Account account) {
		// TODO Auto-generated method stub
		return dao.save(account);
	}
	@Override
	public List<Account> getAdministrators() {
		// TODO Auto-generated method stub
		return dao.getAdministrators();
	}
	@Override
	public List<Account> findAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}
	@Override
	public Account create(Account product) {
		// TODO Auto-generated method stub
		return dao.save(product);
	}
	@Override
	public void delete(String username) {
		// TODO Auto-generated method stub
		dao.deleteById(username);
	}
	@Override
	public Account update(Account product) {
		// TODO Auto-generated method stub
		return dao.save(product);
	}



}

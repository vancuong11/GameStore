package com.valne.service;

import java.util.List;

import com.valne.entity.Account;

public interface AccountService {

	Account findById(String username);

	Account save(Account account);

	List<Account> getAdministrators();
	
	List<Account> findAll();
	
	Account create(Account product);

	void delete(String username);

	Account update(Account product);

}

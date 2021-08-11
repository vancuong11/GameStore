package com.valne.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.valne.entity.Account;

public interface Account_Dao extends JpaRepository<Account,String> {
	@Query("SELECT DISTINCT a.account FROM Authority a WHERE a.role.id IN ('DIRE','ADMIN')")
	List<Account> getAdministrators();
}

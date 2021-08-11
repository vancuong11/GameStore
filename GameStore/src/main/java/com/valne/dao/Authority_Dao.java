package com.valne.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.valne.entity.Account;
import com.valne.entity.Authority;

public interface Authority_Dao extends JpaRepository<Authority, Integer> {
	@Query("SELECT DISTINCT a from Authority a where a.account IN ?1")
	List<Authority> authoritiesOf(List<Account> accounts);
}

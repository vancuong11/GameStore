package com.valne.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.valne.dao.Roler_Dao;
import com.valne.entity.Role;
import com.valne.service.RoleService;
@Service
public class RoleServiceImpl implements RoleService {
	@Autowired
	Roler_Dao roleDao;
	@Override
	public List<Role> findAll() {
		// TODO Auto-generated method stub
		return roleDao.findAll();
	}

}

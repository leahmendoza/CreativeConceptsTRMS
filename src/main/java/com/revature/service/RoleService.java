package com.revature.service;

import java.util.List;

import com.revature.model.Role;
import com.revature.repository.RoleRepositoryImpl;

public class RoleService {
	public List<Role> getAllRoles(){
		return new RoleRepositoryImpl().getAllRoles();
	}
}

package com.revature.repository;

import java.util.List;

import com.revature.model.Role;

public interface RoleRepository {
	List<Role> getAllRoles();
	Role getRoleById(int id);
}

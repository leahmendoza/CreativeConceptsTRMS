package com.revature.repository;

import java.util.List;

import com.revature.model.Employee;

public interface EmployeeRepository {
		
	List<Employee> getAllEmployees();
	Employee getEmployeeById(int id);
	
}

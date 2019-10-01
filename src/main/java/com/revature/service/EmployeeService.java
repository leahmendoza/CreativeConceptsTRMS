package com.revature.service;

import java.util.List;

import com.revature.model.Employee;
import com.revature.repository.EmployeeRepositoryImpl;

public class EmployeeService {
	
	public List<Employee> getAllEmployees(){
		return new EmployeeRepositoryImpl().getAllEmployees(); //Calling the method that gets ALL employees
	}
	
}

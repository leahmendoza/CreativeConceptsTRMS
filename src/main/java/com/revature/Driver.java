package com.revature;

import com.revature.model.Employee;
import com.revature.repository.EmployeeRepositoryImpl;
import com.revature.service.EmployeeService;

public class Driver {
	static int id_employee = 1;
	static String fname = "";
	static String lname = "";
	static String username = "";
	static String password = "";
	static double available = 0;
	static double pending = 0;
	static double awarded = 0;

	static EmployeeService emp = new EmployeeService();
	
	public static void main(String[] args) {
		Employee employee1 = new Employee(id_employee, fname, lname, username, password, available, pending, awarded);
		EmployeeRepositoryImpl eImp = new EmployeeRepositoryImpl();
		
		System.out.println(employee1); //before
		employee1 = eImp.getEmployeeById(1); //selecting id and name
		System.out.println(employee1); //fully populated
		
	}
}

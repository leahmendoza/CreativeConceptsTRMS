package com.revature.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.model.Employee;
import com.revature.util.ConnectionClosers;
import com.revature.util.ConnectionFactory;

public class EmployeeRepositoryImpl implements EmployeeRepository {

	public List<Employee> getAllEmployees() {
		ArrayList<Employee> employees = new ArrayList<>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet set = null;
		final String SQL = "select * from employee";

		try {
			conn = ConnectionFactory.getConnection();
			stmt = conn.createStatement();
			set = stmt.executeQuery(SQL);

			while (set.next()) {
				employees.add(new Employee(set.getInt(1), set.getString(2), set.getString(3), set.getString(4),
						set.getString(5), set.getDouble(6), set.getDouble(7), set.getDouble(8)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionClosers.closeConnection(conn);
			ConnectionClosers.closeResultSet(set);
			ConnectionClosers.closeStatement(stmt);
		}
		return employees;
	}

	public Employee getEmployeeById(int id) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet set = null;
		Employee emp = new Employee();

		try {
			conn = ConnectionFactory.getConnection();
			stmt = conn.prepareStatement("select * from employee where id_employee = ?"); // Select By ID Query
			stmt.setInt(1, id);
			set = stmt.executeQuery(); // To execute:

			while (set.next()) {
				// this result set fills in the empty employee object
				int id_employee = set.getInt(1); // getting result set (position 1) assigning it to id_employee
				emp.setId_employee(id_employee); // this puts the value of the id_employee into the object

				String fname = set.getString(2);
				emp.setFname(fname);

				String lname = set.getString(3);
				emp.setLname(lname);

				String username = set.getString(4);
				emp.setUsername(username);

				String password = set.getString(5);
				emp.setPassword(password);

				Double available = set.getDouble(6);
				emp.setAvailable(available);

				Double pending = set.getDouble(7);
				emp.setPending(pending);

				Double awarded = set.getDouble(8);
				emp.setAwarded(awarded);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close(); // closing connection
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return emp;
	}

}
package com.revature.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.model.Role;
import com.revature.util.ConnectionClosers;
import com.revature.util.ConnectionFactory;

public class RoleRepositoryImpl implements RoleRepository{

	public List<Role> getAllRoles() {
		ArrayList<Role> roles = new ArrayList<>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet set = null;
		final String SQL = "select * from role";
		
		try {
			conn = ConnectionFactory.getConnection();
			stmt = conn.createStatement();
			set = stmt.executeQuery(SQL);
			
			while(set.next()) {
				roles.add(
						new Role (
								set.getInt(1),
								set.getString(2)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionClosers.closeConnection(conn);
			ConnectionClosers.closeResultSet(set);
			ConnectionClosers.closeStatement(stmt);
		}
		return roles;
	}
	
	public Role getRoleById(int id) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet set = null;
		Role role = new Role();

		try {
			conn = ConnectionFactory.getConnection();
			stmt = conn.prepareStatement("select * from role where id_role = ?"); // Select By ID Query
			stmt.setInt(1, id);
			set = stmt.executeQuery(); // To execute:

			while (set.next()) {
				System.out.println(set.getInt(1) + "," + set.getString(2) + set.getString(3));

				// this result set fills in the empty role object
				int id_role = set.getInt(1); // getting result set (position 1) assigning it to id_role
				role.setId_role(id_role); // this puts the value of the id_role into the object
				
				String role_type = set.getString(2);
				role.setRole_type(role_type);

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
		return role;
	}

}

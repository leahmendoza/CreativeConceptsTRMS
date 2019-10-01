package com.revature.model;

public class Role {
	//Role Info Variables
	public int id_role;
	public String role_type;
	
	public Role() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Role(int id_role, String role_type) {
		super();
		this.id_role = id_role;
		this.role_type = role_type;
	}

	public int getId_role() {
		return id_role;
	}

	public void setId_role(int id_role) {
		this.id_role = id_role;
	}

	public String getRole_type() {
		return role_type;
	}

	public void setRole_type(String role_type) {
		this.role_type = role_type;
	}

	@Override
	public String toString() {
		return "Role [id_role=" + id_role + ", role_type=" + role_type + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id_role;
		result = prime * result + ((role_type == null) ? 0 : role_type.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Role other = (Role) obj;
		if (id_role != other.id_role)
			return false;
		if (role_type == null) {
			if (other.role_type != null)
				return false;
		} else if (!role_type.equals(other.role_type))
			return false;
		return true;
	}
	
	
}

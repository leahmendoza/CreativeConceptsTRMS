package com.revature.model;

public class Employee {
	//Employee Info Variables
	public int id_employee;
	public String fname;
	public String lname;
	public String username;
	public String password;
	public double available;
	public double pending;
	public double awarded;
	
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(int id_employee, String fname, String lname, String username, String password, double available,
			double pending, double awarded) {
		super();
		this.id_employee = id_employee;
		this.fname = fname;
		this.lname = lname;
		this.username = username;
		this.password = password;
		this.available = available;
		this.pending = pending;
		this.awarded = awarded;
	}

	public int getId_employee() {
		return id_employee;
	}

	public void setId_employee(int id_employee) {
		this.id_employee = id_employee;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public double getAvailable() {
		return available;
	}

	public void setAvailable(double available) {
		this.available = available;
	}

	public double getPending() {
		return pending;
	}

	public void setPending(double pending) {
		this.pending = pending;
	}

	public double getAwarded() {
		return awarded;
	}

	public void setAwarded(double awarded) {
		this.awarded = awarded;
	}

	@Override
	public String toString() {
		return "Employee [id_employee=" + id_employee + ", fname=" + fname + ", lname=" + lname + ", username="
				+ username + ", password=" + password + ", available=" + available + ", pending=" + pending
				+ ", awarded=" + awarded + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(available);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(awarded);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((fname == null) ? 0 : fname.hashCode());
		result = prime * result + id_employee;
		result = prime * result + ((lname == null) ? 0 : lname.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		temp = Double.doubleToLongBits(pending);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((username == null) ? 0 : username.hashCode());
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
		Employee other = (Employee) obj;
		if (Double.doubleToLongBits(available) != Double.doubleToLongBits(other.available))
			return false;
		if (Double.doubleToLongBits(awarded) != Double.doubleToLongBits(other.awarded))
			return false;
		if (fname == null) {
			if (other.fname != null)
				return false;
		} else if (!fname.equals(other.fname))
			return false;
		if (id_employee != other.id_employee)
			return false;
		if (lname == null) {
			if (other.lname != null)
				return false;
		} else if (!lname.equals(other.lname))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (Double.doubleToLongBits(pending) != Double.doubleToLongBits(other.pending))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

}
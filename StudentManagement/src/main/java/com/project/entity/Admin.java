package com.project.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Admin {
	
	@Id
	@Column
	private int AdminId;
	@Column
	private String Name;
	@Column
	private String Email;
	@Column
	private String Password;
	
	public Admin() {
		
	}

	public int getAdminId() {
		return AdminId;
	}

	public void setAdminId(int adminId) {
		AdminId = adminId;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	@Override
	public String toString() {
		return "Admin [AdminId=" + AdminId + ", Name=" + Name + ", Email=" + Email + ", Password=" + Password + "]";
	}

	public Admin(int adminId, String name, String email, String password) {
		super();
		AdminId = adminId;
		Name = name;
		Email = email;
		Password = password;
	}
	
	

}

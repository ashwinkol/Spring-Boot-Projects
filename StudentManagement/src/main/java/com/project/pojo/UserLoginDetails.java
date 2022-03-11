package com.project.pojo;

public class UserLoginDetails {

	private String Email;
	private String Password;

	public UserLoginDetails() {

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

	public UserLoginDetails(String email, String password) {
		super();
		Email = email;
		Password = password;
	}

	@Override
	public String toString() {
		return "UserLoginDetails [Email=" + Email + ", Password=" + Password + "]";
	}

}

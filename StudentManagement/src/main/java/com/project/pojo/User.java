package com.project.pojo;

public class User {

	private String email;
	private int userId;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "User [email=" + email + ", userId=" + userId + "]";
	}

	

	

	

}

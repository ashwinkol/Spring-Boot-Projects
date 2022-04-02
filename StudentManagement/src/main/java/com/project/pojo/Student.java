package com.project.pojo;

public class Student {

	private String email;
	private int Roll_No;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getRoll_No() {
		return Roll_No;
	}
	public void setRoll_No(int roll_No) {
		Roll_No = roll_No;
	}
	@Override
	public String toString() {
		return "Student [email=" + email + ", Roll_No=" + Roll_No + "]";
	}
	
	
	
}

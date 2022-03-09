package com.project.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Teacher")
public class Teacher {

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int TeacherId;
	@Column
	private String First_Name;
	@Column
	private String Middle_Name;
	@Column
	private String Last_Name;
	@Column
	private String Email;
	@Column
	private String Password;
	@Column
	private String Subject;
	
	
	
	public int getTeacherId() {
		return TeacherId;
	}

	public void setTeacherId(int teacherId) {
		TeacherId = teacherId;
	}

	public String getFirst_Name() {
		return First_Name;
	}

	public void setFirst_Name(String first_Name) {
		First_Name = first_Name;
	}

	public String getMiddle_Name() {
		return Middle_Name;
	}

	public void setMiddle_Name(String middle_Name) {
		Middle_Name = middle_Name;
	}

	public String getLast_Name() {
		return Last_Name;
	}

	public void setLast_Name(String last_Name) {
		Last_Name = last_Name;
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

	public String getSubject() {
		return Subject;
	}

	public void setSubject(String subject) {
		Subject = subject;
	}

	public Teacher() {
		
	}

	public Teacher(int teacherId, String first_Name, String middle_Name, String last_Name, String email,
			String password, String subject) {
		super();
		TeacherId = teacherId;
		First_Name = first_Name;
		Middle_Name = middle_Name;
		Last_Name = last_Name;
		Email = email;
		Password = password;
		Subject = subject;
	}

	@Override
	public String toString() {
		return "Teacher [TeacherId=" + TeacherId + ", First_Name=" + First_Name + ", Middle_Name=" + Middle_Name
				+ ", Last_Name=" + Last_Name + ", Email=" + Email + ", Password=" + Password + ", Subject=" + Subject
				+ "]";
	}

	
}

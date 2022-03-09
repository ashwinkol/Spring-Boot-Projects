package com.project.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Students")
public class Students {
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Roll_No;
	@Column
	private int Prn;
	@Column
	private String FirstName;
	@Column
	private String MiddleName;
	@Column
	private String LastName;
	@Column
	private String Email;
	@Column
	private String Mobile;
	@Column
	private String Photo;
	@Column
	private String Password;
	@Column
	private String Course;
	@Column
	private int Password_Status;
	@Column
	private String Address;
	
	public Students() {
		
	}

	public int getRoll_No() {
		return Roll_No;
	}

	public void setRoll_No(int roll_No) {
		Roll_No = roll_No;
	}

	public int getPrn() {
		return Prn;
	}

	public void setPrn(int prn) {
		Prn = prn;
	}

	public String getFirstName() {
		return FirstName;
	}

	public void setFirstName(String firstName) {
		FirstName = firstName;
	}

	public String getMiddleName() {
		return MiddleName;
	}

	public void setMiddleName(String middleName) {
		MiddleName = middleName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getMobile() {
		return Mobile;
	}

	public void setMobile(String mobile) {
		Mobile = mobile;
	}

	public String getPhoto() {
		return Photo;
	}

	public void setPhoto(String photo) {
		Photo = photo;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public String getCourse() {
		return Course;
	}

	public void setCourse(String course) {
		Course = course;
	}

	public int getPassword_Status() {
		return Password_Status;
	}

	public void setPassword_Status(int password_Status) {
		Password_Status = password_Status;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public Students(int roll_No, int prn, String firstName, String middleName, String lastName, String email,
			String mobile, String photo, String password, String course, int password_Status, String address) {
		super();
		Roll_No = roll_No;
		Prn = prn;
		FirstName = firstName;
		MiddleName = middleName;
		LastName = lastName;
		Email = email;
		Mobile = mobile;
		Photo = photo;
		Password = password;
		Course = course;
		Password_Status = password_Status;
		Address = address;
	}

	@Override
	public String toString() {
		return "Students [Roll_No=" + Roll_No + ", Prn=" + Prn + ", FirstName=" + FirstName + ", MiddleName="
				+ MiddleName + ", LastName=" + LastName + ", Email=" + Email + ", Mobile=" + Mobile + ", Photo=" + Photo
				+ ", Password=" + Password + ", Course=" + Course + ", Password_Status=" + Password_Status
				+ ", Address=" + Address + "]";
	}
	
	
	

}

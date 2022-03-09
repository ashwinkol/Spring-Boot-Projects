package com.project.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="Attendance")
public class Attendance {

	@Id
	@Column
	private int Teacher_Id;
	@Column
	private int Student_Id;
	@Column
	private int Course_Id;
	@Column
	private String Subject;
	@Column
	private String Present_Absent;
	@Column
	private Date date;
	
	public Attendance() {
		
		
	}

	public Attendance(int teacher_Id, int student_Id, int course_Id, String subject, String present_Absent, Date date) {
		super();
		Teacher_Id = teacher_Id;
		Student_Id = student_Id;
		Course_Id = course_Id;
		Subject = subject;
		Present_Absent = present_Absent;
		this.date = date;
	}

	public int getTeacher_Id() {
		return Teacher_Id;
	}

	public void setTeacher_Id(int teacher_Id) {
		Teacher_Id = teacher_Id;
	}

	public int getStudent_Id() {
		return Student_Id;
	}

	public void setStudent_Id(int student_Id) {
		Student_Id = student_Id;
	}

	public int getCourse_Id() {
		return Course_Id;
	}

	public void setCourse_Id(int course_Id) {
		Course_Id = course_Id;
	}

	public String getSubject() {
		return Subject;
	}

	public void setSubject(String subject) {
		Subject = subject;
	}

	public String getPresent_Absent() {
		return Present_Absent;
	}

	public void setPresent_Absent(String present_Absent) {
		Present_Absent = present_Absent;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Attendance [Teacher_Id=" + Teacher_Id + ", Student_Id=" + Student_Id + ", Course_Id=" + Course_Id
				+ ", Subject=" + Subject + ", Present_Absent=" + Present_Absent + ", date=" + date + "]";
	}
	
	
	
}

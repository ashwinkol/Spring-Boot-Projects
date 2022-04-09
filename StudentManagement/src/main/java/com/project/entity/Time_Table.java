package com.project.entity;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Time_Table")
public class Time_Table {
	
	@Id
	@Column
	private int id;
	@Column
	private String Day;
	@Column
	private Date Date;
	@Column
	private String ZoomId;
	@Column
	private String ZoomPassword;
	@Column
	private String Course;
	
	  
	
	public Time_Table() {
		
	}

	

	public Time_Table(int id, String day, java.sql.Date date, String zoomId, String zoomPassword, String course) {
		super();
		this.id = id;
		Day = day;
		Date = date;
		ZoomId = zoomId;
		ZoomPassword = zoomPassword;
		Course = course;
	}



	public String getDay() {
		return Day;
	}

	public void setDay(String day) {
		Day = day;
	}

	public Date getDate() {
		return Date;
	}

	public void setDate(Date date) {
		Date = date;
	}

	public String getZoomId() {
		return ZoomId;
	}

	public void setZoomId(String zoomId) {
		ZoomId = zoomId;
	}

	public String getZoomPassword() {
		return ZoomPassword;
	}

	public void setZoomPassword(String zoomPassword) {
		ZoomPassword = zoomPassword;
	}

	public String getCourse() {
		return Course;
	}

	public void setCourse(String course) {
		Course = course;
	}



	@Override
	public String toString() {
		return "Time_Table [id=" + id + ", Day=" + Day + ", Date=" + Date + ", ZoomId=" + ZoomId + ", ZoomPassword="
				+ ZoomPassword + ", Course=" + Course + "]";
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}

	

}

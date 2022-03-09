package com.project.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Course")
public class Course {

	@Id
	@Column
	private int CourseId;
	@Column
	private String Name;
	
	public Course() {
		
	}

	public Course(int courseId, String name) {
		super();
		CourseId = courseId;
		Name = name;
	}

	public int getCourseId() {
		return CourseId;
	}

	public void setCourseId(int courseId) {
		CourseId = courseId;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	@Override
	public String toString() {
		return "Course [CourseId=" + CourseId + ", Name=" + Name + "]";
	}
	
	
	
}

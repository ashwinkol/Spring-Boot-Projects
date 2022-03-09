package com.project.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Subjects")
public class Subjects {

	@Id
	@Column
	private int SubjectId;
	@Column
	private String Name;
	@Column
	private int CourseId;
	@Column
	private int TeacherId;

	public Subjects() {

	}

	public int getSubjectId() {
		return SubjectId;
	}

	public void setSubjectId(int subjectId) {
		SubjectId = subjectId;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public int getCourseId() {
		return CourseId;
	}

	public void setCourseId(int courseId) {
		CourseId = courseId;
	}

	public int getTeacherId() {
		return TeacherId;
	}

	public void setTeacherId(int teacherId) {
		TeacherId = teacherId;
	}

	public Subjects(int subjectId, String name, int courseId, int teacherId) {
		super();
		SubjectId = subjectId;
		Name = name;
		CourseId = courseId;
		TeacherId = teacherId;
	}

	@Override
	public String toString() {
		return "Subjects [SubjectId=" + SubjectId + ", Name=" + Name + ", CourseId=" + CourseId + ", TeacherId="
				+ TeacherId + "]";
	}

}

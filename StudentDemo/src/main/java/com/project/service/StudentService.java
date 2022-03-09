package com.project.service;

import java.util.List;

import com.project.model.Student;

public interface StudentService {
	public Student saveStudent(Student student);
	public List<Student> getAllStudents();
}

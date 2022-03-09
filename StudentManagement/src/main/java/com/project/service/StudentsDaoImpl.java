package com.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.entity.Students;
import com.project.repository.StudentsDao;

@Service
public class StudentsDaoImpl {

	@Autowired
	public StudentsDao StudentsDao;
	
	public String addStudent(Students student) {
		StudentsDao.save(student);
		return "Student Added Sucsessfully";
	}
	
}

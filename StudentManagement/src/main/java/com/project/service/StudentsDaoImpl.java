package com.project.service;

import java.util.List;
import java.util.Optional;

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
	
	public List<Students> findAllStudent() {
		List<Students> s =  StudentsDao.findAll();
		return s;
	}
	
	public Students findStudent(int id) {
		Optional<Students> student = StudentsDao.findById(id);
		Students s = student.get();
		return s;
		
	}
	
}

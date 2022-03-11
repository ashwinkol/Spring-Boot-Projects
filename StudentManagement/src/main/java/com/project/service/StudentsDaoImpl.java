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
	
	public boolean findStudentByEmail(String email) {
		String val =  StudentsDao.findByEmail(email);
		if(val != null) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean isValidUser(String email,String Password) {
		String isValidUser = StudentsDao.isValidUser(email, Password);
		if(isValidUser != null) {
			return true;
		}
		else {
			return false;
		}
		
		
	}
	
}

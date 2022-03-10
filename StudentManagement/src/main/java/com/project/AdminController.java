package com.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.entity.Students;
import com.project.service.StudentsDaoImpl;

@RestController
@RequestMapping("/Admin")
public class AdminController {

	@Autowired
	private StudentsDaoImpl studentDaoImpl;
	
	@PostMapping("/addStudent")
	public String addStudent(@RequestBody Students student) {
		studentDaoImpl.addStudent(student);
		return "Student Added Sucsessfully";
	}
}

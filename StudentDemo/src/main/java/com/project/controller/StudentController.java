package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.model.Student;
import com.project.service.StudentServiceImpl;

@RestController
@RequestMapping("/Student")
public class StudentController {

	@Autowired
	public StudentServiceImpl studentService;

	@PostMapping("/add")
	public String add(@RequestBody Student student) {
		studentService.saveStudent(student);
		return "Student Added Sucsessfully!!!!";
	}

	@PostMapping("/getAllStudents")
	public List<Student> getStudents() {
		return studentService.getAllStudents();
	}

}

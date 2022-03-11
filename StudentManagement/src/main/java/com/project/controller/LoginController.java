package com.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.pojo.UserLoginDetails;
import com.project.service.StudentsDaoImpl;
import com.project.service.TeacherDaoImpl;

@RestController
@RequestMapping("/Login")
public class LoginController {

	@Autowired
	private StudentsDaoImpl studentDaoImpl;

	@Autowired
	private TeacherDaoImpl teacherDaoImpl;

	@PostMapping("/CheckUser")
	public void loginUser(@RequestBody UserLoginDetails userDetails) {

		boolean s = studentDaoImpl.findStudentByEmail(userDetails.getEmail());

	}

}

package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.entity.Course;
import com.project.entity.Students;
import com.project.service.CourseDaoImpl;
import com.project.service.StudentsDaoImpl;

@RestController
@RequestMapping("/Student")
public class StudentController {
	
	@Autowired
	private StudentsDaoImpl studentDao;
	
	@Autowired
	private CourseDaoImpl courseDao;
	
	@PostMapping("/addStudent")
	public String addStudent(@RequestBody Students student) {
		System.out.println(student.getEmail());
		studentDao.addStudent(student);
		return "Student Added";
	}
	
	@PostMapping("/addCourse")
	public String addCourse(@RequestBody Course course) {
		courseDao.addCourse(course);
		return "Course Added";
	}
	
	@PostMapping("/findStudents")
	public List<Students> findAllStudents() {
		List<Students> s = studentDao.findAllStudent();
		return s;
	}
	
	@PostMapping("/findStudent")
	public Students findStudent(@RequestBody int id) {
		Students s = (Students) studentDao.findStudent(id);
		System.out.println(s.toString());
		return s;
	}
	

}

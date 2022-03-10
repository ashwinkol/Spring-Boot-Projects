package com.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.entity.Course;
import com.project.entity.Notice_Board;
import com.project.entity.Students;
import com.project.entity.Subjects;
import com.project.entity.Teacher;
import com.project.entity.Time_Table;
import com.project.service.CourseDaoImpl;
import com.project.service.Notice_BoardDaoImpl;
import com.project.service.StudentsDaoImpl;
import com.project.service.SubjectsDaoImpl;
import com.project.service.TeacherDaoImpl;
import com.project.service.Time_TableDaoImpl;

@RestController
@RequestMapping("/Admin")
public class AdminController {

	@Autowired
	private StudentsDaoImpl studentDaoImpl;
	
	@Autowired
	private TeacherDaoImpl teacherDaoImpl;
	
	@Autowired
	private SubjectsDaoImpl subjectsDaoImpl;
	
	
	@Autowired
	private Notice_BoardDaoImpl noticeDaoImpl;
	
	@Autowired
	private CourseDaoImpl courseDaoImpl;
	
	@Autowired
	private Time_TableDaoImpl timeTableDaoImpl;
	
	@PostMapping("/addCourse")
	public String addCourse(@RequestBody Course course) {
		courseDaoImpl.addCourse(course);
		return "Course Added Sucsessfully!!!!!!!";
	
	}
	
	
	
	@PostMapping("/addStudent")
	public String addStudent(@RequestBody Students student) {
		studentDaoImpl.addStudent(student);
		return "Student Added Sucsessfully!!!!!!!";
	}
	
	@PostMapping("/addTeacher")
	public String addTeacher(@RequestBody Teacher teacher) {
		teacherDaoImpl.addTeacher(teacher);
		return "Teacher Added Succsesfully!!!!!!!!";
	}
	
	@PostMapping("/addSubject")
	public String addSubject(@RequestBody Subjects subjects) {
		subjectsDaoImpl.addSubject(subjects);
		return "Subject Added Succsesfully!!!!!!";
	}
	
	@PostMapping("/addNotice")
	public String addNotice(@RequestBody Notice_Board notice) {
		noticeDaoImpl.addNotice(notice);
		return "Notice Added Succsesfully!!!!!!!";
	}
	
	@PostMapping("/addTimeTable")
	public String addTimeTable(@RequestBody Time_Table timeTable) {
		timeTableDaoImpl.addTimeTable(timeTable);
		return "Student Added Succsesfull!!!!!!!!!";
	}
}

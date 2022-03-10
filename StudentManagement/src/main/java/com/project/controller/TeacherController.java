package com.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.entity.Attendance;
import com.project.entity.Exam_Performance;
import com.project.service.AttendanceDaoImpl;
import com.project.service.Exam_PerformanceDaoImpl;

@RestController
@RequestMapping("/Teacher")
public class TeacherController {

	@Autowired
	private Exam_PerformanceDaoImpl examMarksDaoImpl;

	@Autowired
	private AttendanceDaoImpl studentAttendanceDaoImpl;

	@RequestMapping("/addMakrs")
	public String addMarksToStudent(@RequestBody Exam_Performance examMakrs) {
		examMarksDaoImpl.addMarks(examMakrs);
		return "Marks Added To Student Sucsessfully.........!";
	}

	@RequestMapping("/addAttendance")
	public String addAttendance(@RequestBody Attendance studentAttendanceData) {

		studentAttendanceDaoImpl.addAttendance(studentAttendanceData);
		return "Student Added Succsesfully...........!";
	}

}

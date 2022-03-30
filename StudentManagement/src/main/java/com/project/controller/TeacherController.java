package com.project.controller;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.entity.Attendance;
import com.project.entity.Exam_Performance;
import com.project.entity.Teacher;
import com.project.service.AttendanceDaoImpl;
import com.project.service.Exam_PerformanceDaoImpl;
import com.project.service.TeacherDaoImpl;

@RestController
@RequestMapping("/Teacher")
public class TeacherController {

	@Autowired
	private Exam_PerformanceDaoImpl examMarksDaoImpl;

	@Autowired
	private AttendanceDaoImpl studentAttendanceDaoImpl;

	@Autowired
	private TeacherDaoImpl teacerDaoImpl;

	@PostMapping("/Login")
	public boolean TeacherLogin(@RequestBody Teacher isValidTeacher) {
		boolean isValidEmail = teacerDaoImpl.isValidEmail(isValidTeacher.getEmail());
		if (isValidEmail) {
			try {
				String inputPassword = isValidTeacher.getPassword();

				// Static getInstance method is called with hashing MD5
				MessageDigest md = MessageDigest.getInstance("MD5");

				// digest() method is called to calculate message digest
				// of an input digest() return array of byte
				byte[] messageDigest = md.digest(inputPassword.getBytes());

				// Convert byte array into signum representation
				BigInteger no = new BigInteger(1, messageDigest);

				// Convert message digest into hex value
				String hashtext = no.toString(16);

				while (hashtext.length() < 32) {
					hashtext = "0" + hashtext;
				}
				boolean isValidUser = teacerDaoImpl.isValidTeacher(isValidTeacher.getEmail(), hashtext);
				if (isValidUser) {
					return true;
				}

			}

			// For specifying wrong message digest algorithms
			catch (NoSuchAlgorithmException e) {
				throw new RuntimeException(e);
			}

		}

		return false;
	}

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

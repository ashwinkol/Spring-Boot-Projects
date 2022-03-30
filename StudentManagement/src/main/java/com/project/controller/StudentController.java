package com.project.controller;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.entity.Course;
import com.project.entity.Students;
import com.project.pojo.User;
import com.project.service.CourseDaoImpl;
import com.project.service.StudentsDaoImpl;

@RestController
@RequestMapping("/Student")
@CrossOrigin(origins ="http://localhost:3000")

public class StudentController {

	@Autowired
	private StudentsDaoImpl studentDao;

	@Autowired
	private CourseDaoImpl courseDao;

	@Autowired
	private StudentsDaoImpl studentDaoImpl;

	@PostMapping("/Login")
	public boolean StudentLogin(@RequestBody Students studentDetails) {

		boolean validUserEmail = studentDaoImpl.findStudentByEmail(studentDetails.getEmail());

		if (validUserEmail) {
			try {
				String inputPassword = studentDetails.getPassword();

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

				boolean isValidUser = studentDaoImpl.isValidUser(studentDetails.getEmail(), hashtext);
				if (isValidUser) {
					return true;
				}

			}

			// For specifying wrong message digest algorithms
			catch (NoSuchAlgorithmException e) {
				throw new RuntimeException(e);
			}

		} else {
			return false;
		}

		return false;

	}

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
	public Students findStudent() {
		Students s = (Students) studentDao.findStudent(1);
		System.out.println(s.toString());
		return s;
	}

}

package com.project.controller;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.entity.Admin;
import com.project.entity.Course;
import com.project.entity.Notice_Board;
import com.project.entity.Students;
import com.project.entity.Subjects;
import com.project.entity.Teacher;
import com.project.entity.Time_Table;
import com.project.service.AdminDaoImpl;
import com.project.service.CourseDaoImpl;
import com.project.service.Notice_BoardDaoImpl;
import com.project.service.StudentsDaoImpl;
import com.project.service.SubjectsDaoImpl;
import com.project.service.TeacherDaoImpl;
import com.project.service.Time_TableDaoImpl;

@RestController
@RequestMapping("/Admin")
@CrossOrigin
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

	@Autowired
	private AdminDaoImpl adminDaoImpl;

	@PostMapping("/Login")
	public boolean isValidAdmin(@RequestBody Admin isValidAdmin) {
		boolean isValidEmail = adminDaoImpl.isValidEmail(isValidAdmin.getEmail());
		if (isValidEmail) {
			try {
				String inputPassword = isValidAdmin.getPassword();

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

				boolean isValidUser = adminDaoImpl.isValidAdmin(isValidAdmin.getEmail(), hashtext);
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

	@PostMapping("/addCourse")
	public String addCourse(@RequestBody Course course) {
		courseDaoImpl.addCourse(course);
		return "Course Added Sucsessfully!!!!!!!";

	}

	@PostMapping("/addStudent")
	public String addStudent(@RequestBody Students student) {
		String inputPassword = null;

		try {
			inputPassword = student.getPassword();

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

			student.setPassword(hashtext);

		}

		// For specifying wrong message digest algorithms
		catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}
		studentDaoImpl.addStudent(student);
		return "Student Added Sucsessfully!!!!!!!";
	}
	
	
	@PostMapping("/deleteStudent")
	public String removeTeacher(@RequestBody Students id) {
		return studentDaoImpl.removeStudent(id.getRoll_No());
	}

	@PostMapping("/addTeacher")
	public String addTeacher(@RequestBody Teacher teacher) {
		String inputPassword = null;

		try {
			inputPassword = teacher.getPassword();

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

			teacher.setPassword(hashtext);

		}

		// For specifying wrong message digest algorithms
		catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}
		teacherDaoImpl.addTeacher(teacher);
		return "Teacher Added Sucsessfully!!!!!!!";
	}
	
	@PostMapping("/deleteTeacher")
	public String removeTeacher(@RequestBody Teacher id) {
		return teacherDaoImpl.removeTeacher(id.getTeacherId());
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

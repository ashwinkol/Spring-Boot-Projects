package com.project.controller;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.entity.Course;
import com.project.entity.Notice_Board;
import com.project.entity.Response;
import com.project.entity.Students;
import com.project.entity.Subjects;
import com.project.entity.Teacher;
import com.project.entity.Time_Table;
import com.project.pojo.Credentials;
import com.project.pojo.User;
import com.project.service.AdminDaoImpl;
import com.project.service.CourseDaoImpl;
import com.project.service.Notice_BoardDaoImpl;
import com.project.service.StudentsDaoImpl;
import com.project.service.SubjectsDaoImpl;
import com.project.service.TeacherDaoImpl;
import com.project.service.Time_TableDaoImpl;

//This is comment from kshitijk branch
@RestController
@RequestMapping("/Admin")
@CrossOrigin(origins = "http://localhost:3000")
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

	// Hello From Admin Controller

	@PostMapping(value = "/Login")
	public ResponseEntity<?> isValidAdmin(@RequestBody Credentials isValidAdmin, HttpSession session) {
		boolean isValidEmail = adminDaoImpl.isValidEmail(isValidAdmin.getEmail());
		if (isValidEmail) {
			try {
				String inputPassword = isValidAdmin.getPassword();

				MessageDigest md = MessageDigest.getInstance("MD5");

				byte[] messageDigest = md.digest(inputPassword.getBytes());

				BigInteger no = new BigInteger(1, messageDigest);

				String hashtext = no.toString(16);

				while (hashtext.length() < 32) {
					hashtext = "0" + hashtext;
				}

				boolean isValidUser = adminDaoImpl.isValidAdmin(isValidAdmin.getEmail(), hashtext);
				if (isValidUser) {
					User userData = new User();
					userData.setEmail(isValidAdmin.getEmail());
					int userId = adminDaoImpl.getUserId(isValidAdmin.getEmail());
					userData.setUserId(userId);
					return Response.success(userData);

				}

			}

			catch (NoSuchAlgorithmException e) {
				throw new RuntimeException(e);
			}

		}
		return Response.error("Invalid Email Or Password");
	}

	@PostMapping("/LogOut")
	public void LogOut(HttpSession session) {
		session.invalidate();
	}

	@PostMapping("/addCourse/{Name}")
	public ResponseEntity<?> addCourse(@ModelAttribute Course Name) {
		return Response.success(courseDaoImpl.addCourse(Name));

	}

	@PostMapping("/addStudent")
	public ResponseEntity<?> addStudent(@ModelAttribute Students student) {
		String inputPassword = null;
		boolean checkIfUserExist = studentDaoImpl.findStudentByEmail(student.getEmail());
		if (!checkIfUserExist) {
			try {
				inputPassword = student.getPassword();

				MessageDigest md = MessageDigest.getInstance("MD5");

				byte[] messageDigest = md.digest(inputPassword.getBytes());

				BigInteger no = new BigInteger(1, messageDigest);

				String hashtext = no.toString(16);

				while (hashtext.length() < 32) {
					hashtext = "0" + hashtext;
				}

				student.setPassword(hashtext);

			}

			catch (NoSuchAlgorithmException e) {
				throw new RuntimeException(e);
			}
			studentDaoImpl.addStudent(student);
			return Response.success("Done");
			 
		} else {

			return Response.error("Invalid User Name Or Password");
		}
	}

	@DeleteMapping("/deleteStudent/{email}")
	public ResponseEntity<?> removeTeacher(@PathVariable String email) {
		System.out.println("We Got Email: "+email);
		return Response.success(studentDaoImpl.deleteStudentByEmail(email));
	}

	@PostMapping("/addTeacher")
	public ResponseEntity<?> addTeacher(@ModelAttribute Teacher teacher) {
		String inputPassword = null;
		try {
			inputPassword = teacher.getPassword();

			MessageDigest md = MessageDigest.getInstance("MD5");

			byte[] messageDigest = md.digest(inputPassword.getBytes());

			BigInteger no = new BigInteger(1, messageDigest);

			String hashtext = no.toString(16);

			while (hashtext.length() < 32) {
				hashtext = "0" + hashtext;
			}

			teacher.setPassword(hashtext);

		}

		catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}
		teacherDaoImpl.addTeacher(teacher);
		return Response.success("Teacher Added");

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
	public ResponseEntity<?> addNotice(@RequestBody Notice_Board notice) {
		noticeDaoImpl.addNotice(notice);
		return Response.success("Notice Added");
	}
	
	@DeleteMapping("/deleteNotice/{id}")
	public ResponseEntity<?> deleteNotice(@PathVariable int id){
		return Response.success(noticeDaoImpl.deleteNotice(id));
	}

	@PostMapping("/addTimeTable")
	public ResponseEntity<?> addTimeTable(@ModelAttribute Time_Table timeTable) {
		timeTableDaoImpl.addTimeTable(timeTable);
		return Response.success("Time Table Added");
	}

	@GetMapping("/showNoticeBoard")
	public ResponseEntity<?> showNoticeBoard() {

		return Response.success(noticeDaoImpl.getNoticeBoard());

	}

	@GetMapping("/showTimeTable")
	public List<Time_Table> showTimeTable() {
		return timeTableDaoImpl.getTimeTable();
	}

	@GetMapping("/showAllStudents")
	public List<Students> showAllStudents() {
		return studentDaoImpl.findAllStudent();
	}
}

package com.project.controller;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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
import com.project.pojo.User;
import com.project.service.AdminDaoImpl;
import com.project.service.CourseDaoImpl;
import com.project.service.Notice_BoardDaoImpl;
import com.project.service.StudentsDaoImpl;
import com.project.service.SubjectsDaoImpl;
import com.project.service.TeacherDaoImpl;
import com.project.service.Time_TableDaoImpl;

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

	@PostMapping(value = "/Login")
	public boolean isValidAdmin(@RequestBody User isValidAdmin, HttpSession session) {
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
					session.setAttribute("email", isValidAdmin.getEmail());
					System.out.println(session.getAttribute("email"));
					return true;

				}

			}

			catch (NoSuchAlgorithmException e) {
				throw new RuntimeException(e);
			}

		}
		return false;
	}

	@PostMapping("/LogOut")
	public void LogOut(HttpSession session) {
		session.invalidate();
	}

	@PostMapping("/addCourse")
	public String addCourse(@ModelAttribute Course course) {
		System.out.println(course.getName());
		System.out.println(course.toString());
		courseDaoImpl.addCourse(course);
		return "Done";

	}


	@PostMapping("/addStudent")
	public String addStudent(@RequestBody Students student) {
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
			return "Student Added Sucsessfully!!!!!!!";
		} else {

			return "Email Id Already Exist";
		}
	}

	@PostMapping("/deleteStudent")
	public String removeTeacher(@RequestBody Students id) {
		return studentDaoImpl.removeStudent(id.getRoll_No());
	}

	@PostMapping("/addTeacher")
	public String addTeacher(@RequestBody Teacher teacher) {
		String inputPassword = null;
		boolean checkIfEmailExist = teacherDaoImpl.checkIfExist(teacher.getEmail());
		if(!checkIfEmailExist) {
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
		return "Teacher Added Sucsessfully!!!!!!!";
		
		}
		
		else {
			return "Email Id Already Exist";
		}
		
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
		return "Done";
	}

	@GetMapping("/showNoticeBoard")
	public List<Notice_Board> showNoticeBoard(HttpSession session) {
		Object email = session.getAttribute("email");
		System.out.println("Email: " + email);
		System.out.println("Session: " + session.getAttribute("email"));
		return noticeDaoImpl.getNoticeBoard();
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

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

import com.project.entity.Attendance;
import com.project.entity.Exam_Performance;
import com.project.entity.Notice_Board;
import com.project.entity.Students;
import com.project.entity.Time_Table;
import com.project.pojo.User;
import com.project.pojo.UserId;
import com.project.service.AttendanceDaoImpl;
import com.project.service.CourseDaoImpl;
import com.project.service.Exam_PerformanceDaoImpl;
import com.project.service.Notice_BoardDaoImpl;
import com.project.service.StudentsDaoImpl;
import com.project.service.Time_TableDaoImpl;

@RestController
@RequestMapping("/Student")
@CrossOrigin(origins = "http://localhost:3000")

public class StudentController {

	@Autowired
	private StudentsDaoImpl studentDao;

	@Autowired
	private CourseDaoImpl courseDao;

	@Autowired
	private StudentsDaoImpl studentDaoImpl;

	@Autowired
	private Notice_BoardDaoImpl noticeBoard;

	@Autowired
	private Time_TableDaoImpl timeTable;

	@Autowired
	private AttendanceDaoImpl attendanceDaoImpl;

	@Autowired
	private Exam_PerformanceDaoImpl examPerformanceDao;

	int StudentRollNo = 0;

	@PostMapping("/Login")
	public boolean StudentLogin(@RequestBody User studentDetails, HttpSession session) {

		boolean validUserEmail = studentDaoImpl.findStudentByEmail(studentDetails.getEmail());

		if (validUserEmail) {
			try {
				String inputPassword = studentDetails.getPassword();

				MessageDigest md = MessageDigest.getInstance("MD5");

				byte[] messageDigest = md.digest(inputPassword.getBytes());

				BigInteger no = new BigInteger(1, messageDigest);

				String hashtext = no.toString(16);

				while (hashtext.length() < 32) {
					hashtext = "0" + hashtext;
				}

				boolean isValidUser = studentDaoImpl.isValidUser(studentDetails.getEmail(), hashtext);
				if (isValidUser) {
					User u = new User();
					u.setEmail(studentDetails.getEmail());
					session.setAttribute("email", studentDetails.getEmail());
					int rollNo = studentDao.getStudentByEmail(u);
					System.out.println("Roll NO Goiing to set " + rollNo);
					session.setAttribute("RollNo", rollNo);
					return true;
				}

			}

			catch (NoSuchAlgorithmException e) {
				throw new RuntimeException(e);
			}

		} else {
			return false;
		}

		return false;

	}

	@PostMapping("/LogOut")
	public void LogOut(HttpSession session) {
		session.invalidate();
	}

	@PostMapping("/findStudents")
	public List<Students> findAllStudents() {
		List<Students> s = studentDao.findAllStudent();
		return s;
	}

	@PostMapping("/findStudent")
	public Students findStudent(@ModelAttribute UserId user) {
		Students student = (Students) studentDao.findStudent(user.getId());

		return student;
	}

	@GetMapping("/showNoticeBoard")
	public List<Notice_Board> showNoticeBoard() {
		return noticeBoard.getNoticeBoard();
	}

	@GetMapping("/showTimeTable")
	public List<Time_Table> showTimeTable() {
		return timeTable.getTimeTable();
	}

	@GetMapping("/getStudentByEmail")
	public void showStudent(HttpSession session) {
		String email = (String) session.getAttribute("email");
		System.out.println(email);
	}


	@GetMapping("/getStudentExamData")
	public List<Exam_Performance> getExamDetails() {
		return examPerformanceDao.getExamMarks(1);
	}

	@GetMapping("/getStudentAttendance")
	public List<Attendance> getAttendance(HttpSession session) {
		System.out.println("Seesion in Get Attendance " + session.getAttribute("RollNo"));
		System.out.println("Seesion in Get Attendance " + session.getAttribute("email"));
		List<Attendance> studentAttendance = attendanceDaoImpl.getAttendanceById(1);
		return studentAttendance;
	}

}

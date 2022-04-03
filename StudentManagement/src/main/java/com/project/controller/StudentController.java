package com.project.controller;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Optional;

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
import com.project.pojo.Student;
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
@CrossOrigin(origins ="http://localhost:3000")

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
	public boolean StudentLogin(@ModelAttribute Students studentDetails,HttpSession session) {

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
					Student student = new Student();
					User user = new User();
					user.setEmail(studentDetails.getEmail());
					
					StudentRollNo = studentDaoImpl.getStudentByEmail(user);
					student.setEmail(user.getEmail());
					student.setRoll_No(StudentRollNo);
					
					session.setAttribute("email", user.getEmail());
					session.setAttribute("rollNo", student.getRoll_No());
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
	
	@GetMapping("/getStudentAttendance")
	public List<Attendance> getAttendance() {
		
		List<Attendance> studentAttendance = attendanceDaoImpl.getAttendanceById(1);
		return studentAttendance;
	}
	 
	@GetMapping("/getStudentExamData") 
	public List<Exam_Performance> getExamDetails() {
		return examPerformanceDao.getExamMarks(1);
	}

}

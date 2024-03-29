package com.project.controller;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.entity.Attendance;
import com.project.entity.Exam_Performance;
import com.project.entity.Notice_Board;
import com.project.entity.Response;
import com.project.entity.Students;
import com.project.entity.Time_Table;
import com.project.pojo.Credentials;
import com.project.pojo.StudentCourse;
import com.project.pojo.TeacherAndStudentData;
import com.project.pojo.User;
import com.project.service.AttendanceDaoImpl;
import com.project.service.Exam_PerformanceDaoImpl;
import com.project.service.Notice_BoardDaoImpl;
import com.project.service.StudentsDaoImpl;
import com.project.service.TeacherDaoImpl;
import com.project.service.Time_TableDaoImpl;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/Teacher")
public class TeacherController {

	@Autowired
	private Exam_PerformanceDaoImpl examMarksDaoImpl;

	@Autowired
	private AttendanceDaoImpl studentAttendanceDaoImpl;

	@Autowired
	private TeacherDaoImpl teacerDaoImpl;

	@Autowired
	private Notice_BoardDaoImpl noticeBoard;

	@Autowired
	private Time_TableDaoImpl timeTableDaoImpl;

	@Autowired
	private StudentsDaoImpl studentsDaoImpl;
 
	@PostMapping("/Login")
	public ResponseEntity<?> TeacherLogin(@RequestBody Credentials isValidTeacher, HttpSession session) {
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
					User userData = new User();
					userData.setEmail(isValidTeacher.getEmail());
					int userId = teacerDaoImpl.getUserId(isValidTeacher.getEmail());
					userData.setUserId(userId);
					return Response.success(userData);
				}
				else {
					Response.error("Invalid User Name Or Password");
				}

			}

			// For specifying wrong message digest algorithms
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

	@GetMapping("/getNoticeBoard")
	public List<Notice_Board> showNoticeBoard() {
		return noticeBoard.getNoticeBoard();
	}

	@GetMapping("/showTimeTable")
	public List<Time_Table> showTimeTable() {
		return timeTableDaoImpl.getTimeTable();
	}
 
	@GetMapping("/getAllStudentList")
	public List<Students> getAllStudents(@ModelAttribute StudentCourse courseName) {
		return studentsDaoImpl.getAllStudents(courseName);
	}

	// get teacher Id by Session
	@GetMapping("/getStudentData/{studentId}/{teacherId}")
	public ResponseEntity<?> getData(@PathVariable int studentId, @PathVariable int teacherId) {	
		System.out.println("Teacher Id: "+teacherId);
		System.out.println("Student Id: "+studentId);
		return Response.success(studentAttendanceDaoImpl.getStudentAttendanceData(teacherId, studentId));
	}
  
}

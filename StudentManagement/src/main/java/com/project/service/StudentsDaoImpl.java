package com.project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.entity.Attendance;
import com.project.entity.Response;
import com.project.entity.Students;
import com.project.pojo.StudentCourse;
import com.project.pojo.User;
import com.project.repository.StudentsDao;

@Service
public class StudentsDaoImpl {

	@Autowired
	public StudentsDao StudentsDao;

	@Autowired
	private AttendanceDaoImpl AttendanceDao;

	public String addStudent(Students student) {
		StudentsDao.save(student);
		return "Student Added Sucsessfully";
	}

	public Students findStudent(int id) {
		Optional<Students> student = StudentsDao.findById(id);
		Students s = student.get();
		return s;

	}

	public boolean findStudentByEmail(String email) {
		String val = StudentsDao.findByEmail(email);
		if (val != null) {
			return true;
		} else {
			return false;
		}
	}

	public int getStudentByEmail(User user) {
		int stu = StudentsDao.getStudentByEmail(user.getEmail());

		return stu;
	}

	public boolean isValidUser(String email, String Password) {
		String isValidUser = StudentsDao.isValidUser(email, Password);
		if (isValidUser != null) {
			return true;
		} else {
			return false;
		}

	}

	public ResponseEntity<?> deleteStudentByEmail(String email){
		return Response.success(StudentsDao.deleteStudentByEmail(email));
	}

	public List<Students> getAllStudents(StudentCourse course) {
		List<Students> result = StudentsDao.getStudents("Abcd");

		return result;
	}

	public List<Students> findAllStudent() {
		List<Students> s = StudentsDao.findAll();
		return s;
	}

	public List<Attendance> getAllAttendance(Integer id) {
		List<Attendance> allAttendance = AttendanceDao.getAttendanceById(id);

		return allAttendance;
	}

}

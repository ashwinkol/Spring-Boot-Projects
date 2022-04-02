package com.project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.entity.Attendance;
import com.project.entity.Students;
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

	public List<Students> findAllStudent() {
		List<Students> s = StudentsDao.findAll();
		return s;
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

	public String removeStudent(int id) {
		try {
		StudentsDao.deleteById(id);
		}
		catch (Exception e) {
			return e.getMessage();
		}
		
		return "Student Deleted!!!!";

	}
	
	public List<Attendance> getAllAttendance(int id) {
		System.out.println("Id in Sudent Dao "+id);
		List<Attendance> allAttendance = AttendanceDao.getAttendance(id);
		return allAttendance;
	}

}

package com.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import com.project.entity.Attendance;
import com.project.entity.Teacher;
import com.project.repository.TeacherDao;
import com.project.repository.Time_TableDao;

@Service
public class TeacherDaoImpl {

	@Autowired
	private TeacherDao teacherDao;
	
	@Autowired
	private Time_TableDao timeTableDaoImpl;
	
	@Autowired
	private AttendanceDaoImpl attendanceDaoImpl;

	public void addTeacher(Teacher teacher) {
		teacherDao.save(teacher);

	}

	public boolean isValidTeacher(String email, String password) {
		String isValidUser = teacherDao.isValidTeacher(email, password);
		if (isValidUser != null) {
			return true;
		} else {
			return false;
		}

	}

	public boolean isValidEmail(String email) {
		String val = teacherDao.isValidEmail(email);
		if (val != null) {
			return true;
		} else {
			return false;
		}
	}

	@Query("SET FOREIGN_KEY_CHECKS=0")
	public String removeTeacher(int id) {

		try {
			teacherDao.deleteById(id);

		} catch (Exception e) {
			return e.getMessage();
		}
		return "Teacher Deleted!!!!";
	}
	
	
	

}

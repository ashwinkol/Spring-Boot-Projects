package com.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

	public boolean checkIfExist(String email) {
		String val = teacherDao.isValidEmail(email);
		if (val != null) {
			return true;
		} else {
			return false;
		}
	}

	public void removeTeacher(int id) {
		teacherDao.removeTeacher(id);
	}

	public int getTeacherId(String email) {
		return teacherDao.getUserId(email);
	}

	public int getUserId(String email) {
		int userId = teacherDao.getUserId(email);
		return userId;
	}
	

	public List<Teacher> getAllTeachers() {
		return teacherDao.findAll();
	}

}

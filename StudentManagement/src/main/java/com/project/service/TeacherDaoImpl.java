package com.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.entity.Teacher;
import com.project.repository.TeacherDao;

@Service
public class TeacherDaoImpl {

	@Autowired
	private TeacherDao teacherDao;
	
	
	public void addTeacher(Teacher teacher) {
		teacherDao.save(teacher);
		
	}
}

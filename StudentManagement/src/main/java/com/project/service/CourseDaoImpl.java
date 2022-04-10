package com.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.entity.Course;
import com.project.repository.CourseDao;

@Service
public class CourseDaoImpl {

	@Autowired
	private CourseDao CourseDao;
	
	public Course addCourse(Course course) {
		return CourseDao.save(course);		
	}
	
	public List<Course> getAllCourse() {
		return CourseDao.findAll();
	}
	
	public void deleteCourse(int id) {
		 CourseDao.deleteCourse(id);
	} 
}

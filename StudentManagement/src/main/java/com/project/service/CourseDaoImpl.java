package com.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import com.project.entity.Course;
import com.project.repository.CourseDao;

@Service
public class CourseDaoImpl {

	@Autowired
	private CourseDao CourseDao;
	
	public String addCourse(@RequestBody Course course) {
		CourseDao.save(course);
		
		return "Course Added";
	}
}

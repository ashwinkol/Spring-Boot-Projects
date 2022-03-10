package com.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.entity.Subjects;
import com.project.repository.SubjectsDao;

@Service
public class SubjectsDaoImpl {

	@Autowired
	private SubjectsDao subjectsDao;
	
	public void addSubject(Subjects subjects) {
		subjectsDao.save(subjects);
	}
	
}

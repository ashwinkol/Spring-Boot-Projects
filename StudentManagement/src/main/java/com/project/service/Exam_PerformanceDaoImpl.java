package com.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.entity.Exam_Performance;
import com.project.repository.Exam_PerformanceDao;

@Service
public class Exam_PerformanceDaoImpl {
	
	@Autowired
	private Exam_PerformanceDao examPerformance;
	
	
	public void addMarks(Exam_Performance examMarks) {
		examPerformance.save(examMarks);
	}
	
	public List<Exam_Performance> getExamMarks(int id){
		List<Exam_Performance> examMarks = examPerformance.getExamMarks(id);
		return examMarks;
	}

}

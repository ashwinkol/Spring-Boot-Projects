package com.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.project.entity.Exam_Performance;
@Repository
public interface Exam_PerformanceDao extends JpaRepository<Exam_Performance, Integer> {

	@Query(value = "select * from Exam_Performance where Roll_No = ?1",nativeQuery = true)
	public List<Exam_Performance> getExamMarks(Integer id);
 
}

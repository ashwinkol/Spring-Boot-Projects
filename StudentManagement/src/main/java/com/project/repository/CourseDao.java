package com.project.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.project.entity.Course;
@Repository
@Transactional
public interface CourseDao extends JpaRepository<Course, Integer> {

	@Modifying
	@Query(value="delete from Course where CourseId = ?1",nativeQuery = true)
	public void deleteCourse(int id); 

} 

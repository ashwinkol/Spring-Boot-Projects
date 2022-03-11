package com.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.project.entity.Teacher;

public interface TeacherDao extends JpaRepository<Teacher, Integer> {


	@Query("select Email from Teacher where email = ?1 ")
	public String isValidEmail(String email);
	
	@Query("select Email,Password from Teacher where email = ?1 and password = ?2")
	public String isValidTeacher(String email,String password);

}

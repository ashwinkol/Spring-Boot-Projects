package com.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.project.entity.Teacher;

@Repository
public interface TeacherDao extends JpaRepository<Teacher, Integer> {


	@Query("select Email from Teacher where email = ?1 ")
	public String isValidEmail(String email);
	
	@Query("select Email from Teacher where email = ?1 ")
	public boolean checkIfExist(String email);
	
	@Query("select TeacherId from Teacher where Email = ?1 ")
	public int getUserId(String email);
	
	@Query("select Email,Password from Teacher where email = ?1 and password = ?2")
	public String isValidTeacher(String email,String password);
	
	@Query("delete from Teacher where TeacherId = ?1")
	public String removeTeacher(int id);
	
	

	
}

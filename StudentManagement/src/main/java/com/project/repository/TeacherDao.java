package com.project.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.project.entity.Teacher;

@Repository
@Transactional
public interface TeacherDao extends JpaRepository<Teacher, Integer> {


	@Query("select Email from Teacher where email = ?1 ")
	public String isValidEmail(String email);
	
	@Query("select Email from Teacher where email = ?1 ")
	public boolean checkIfExist(String email);
	
	@Query("select TeacherId from Teacher where Email = ?1 ")
	public int getUserId(String email);
	
	@Query("select Email,Password from Teacher where email = ?1 and password = ?2")
	public String isValidTeacher(String email,String password);
	
	//SET foreign_key_checks = 1;
	@Modifying
	@Query("delete from Teacher where TeacherId = ?1")
	public void removeTeacher(int id);
	
	@Query("select TeacherId,First_Name,Last_Name,Subject from Teacher")
	public List<Teacher> getTeachers();
		 
}

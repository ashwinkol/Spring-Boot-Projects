package com.project.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.project.entity.Students;
@Repository
@Transactional

public interface StudentsDao extends JpaRepository<Students, Integer > {
	
	@Query("select Email from Students where email = ?1 ")
	public String findByEmail(String email);
	
	@Modifying
	@Query("delete from Students where Email =  ?1")
	public int deleteStudentByEmail(String email);
	
	@Query("select Roll_No from Students where Email = ?1")
	public int getStudentByEmail(String email);

	@Query("select Email,Password from Students where email = ?1 and password = ?2")
	public String isValidUser(String email,String password);
	
	@Query(value = "SELECT * FROM Students WHERE Course = ?1",nativeQuery = true)
	public List<Students> getStudents(String course); 
 
}

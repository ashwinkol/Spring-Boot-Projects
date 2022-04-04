package com.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.project.entity.Admin;
@Repository
public interface AdminDao extends JpaRepository<Admin, Integer > {
	
	@Query("select Email from Admin where Email = ?1 ")
	public String isValidEmail(String email);
	
	
	
	@Query("select Email,Password from Admin where email = ?1 and password = ?2")
	public String isValidAdmin(String email,String password);
	
	
}

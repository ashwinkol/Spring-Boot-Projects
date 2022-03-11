package com.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.project.entity.Students;

public interface StudentsDao extends JpaRepository<Students, Integer > {
	
	@Query("select Email from Students where email = ?1 ")
	public String findByEmail(String email);
}

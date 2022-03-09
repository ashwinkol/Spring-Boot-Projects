package com.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.entity.Students;

public interface StudentsDao extends JpaRepository<Students, Integer > {

}

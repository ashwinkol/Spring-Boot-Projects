package com.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.entity.Teacher;

public interface TeacherDao extends JpaRepository<Teacher, Integer> {

}

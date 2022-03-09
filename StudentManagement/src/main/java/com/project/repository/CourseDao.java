package com.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.entity.Course;

public interface CourseDao extends JpaRepository<Course, Integer> {

}

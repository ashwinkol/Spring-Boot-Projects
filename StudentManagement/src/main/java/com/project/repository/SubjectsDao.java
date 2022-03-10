package com.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.entity.Subjects;

public interface SubjectsDao extends JpaRepository<Subjects, Integer> {

}

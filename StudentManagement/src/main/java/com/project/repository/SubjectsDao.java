package com.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.entity.Subjects;
@Repository
public interface SubjectsDao extends JpaRepository<Subjects, Integer> {

}

package com.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.entity.Notice_Board;
@Repository
public interface Notice_BoardDao extends JpaRepository<Notice_Board, Integer>{

}

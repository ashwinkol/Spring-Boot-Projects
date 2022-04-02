package com.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.project.entity.Attendance;

public interface AttendanceDao extends JpaRepository<Attendance, Integer> {

	@Query("select Subject,Present_Absent,date from Attendance where Student_Id  = ?1 ")
	public List<Attendance> findAllById(int id);

}

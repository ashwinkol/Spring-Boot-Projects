package com.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.project.entity.Attendance;

public interface AttendanceDao extends JpaRepository<Attendance, Integer> {

	@Query(value = "select * from Attendance where Student_Id = ?1",nativeQuery = true)
	public List<Attendance> getAttendance(Integer id); 
 
}

package com.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.entity.Attendance;

public interface AttendanceDao extends JpaRepository<Attendance, Integer> {

}

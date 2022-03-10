package com.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.entity.Attendance;
import com.project.repository.AttendanceDao;

@Service
public class AttendanceDaoImpl {

	@Autowired
	private AttendanceDao studentAttendanceDao;
	
	public void addAttendance(Attendance studentAttendance) {
		studentAttendanceDao.save(studentAttendance);
	}
		
}

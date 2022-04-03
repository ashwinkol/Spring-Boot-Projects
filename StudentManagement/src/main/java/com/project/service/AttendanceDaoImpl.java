package com.project.service;

import java.util.List;

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
	
	public List<Attendance> getAttendanceById(Integer id){
		return studentAttendanceDao.getAttendance(id);
	}
	
	public List<Attendance> getAttendance() {
		return studentAttendanceDao.findAll();
	}
	
	public List<Attendance> getStudentAttendanceData(int teacherId,int studentId) {
		return studentAttendanceDao.getStudentRecord(teacherId, studentId);
	}
		
}

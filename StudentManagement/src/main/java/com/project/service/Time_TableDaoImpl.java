package com.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.entity.Response;
import com.project.entity.Time_Table;
import com.project.pojo.TimeTable;
import com.project.repository.Time_TableDao;

@Service
public class Time_TableDaoImpl {

	@Autowired
	private Time_TableDao timeTableDao;
	
	public void addTimeTable(Time_Table timeTable) {
		timeTableDao.save(timeTable);
	}
	
	public List<Time_Table> getTimeTable() {
		return timeTableDao.getTimeTable();
	}
	
	public ResponseEntity<?> deleteTimeTable(int id){
		timeTableDao.deleteTimeTable(id);
		return Response.success("Deleted");
	}
	
	
}

package com.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.entity.Time_Table;
import com.project.repository.Time_TableDao;

@Service
public class Time_TableDaoImpl {

	@Autowired
	private Time_TableDao timeTableDao;
	
	public void addTimeTable(Time_Table timeTable) {
		timeTableDao.save(timeTable);
	}
}

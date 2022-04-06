package com.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.repository.AdminDao;

@Service
public class AdminDaoImpl {

	@Autowired
	private AdminDao AdminDao;
	
	public boolean isValidAdmin(String email,String password) {
		String isValidUser = AdminDao.isValidAdmin(email,password);
		if(isValidUser != null) {
			return true;
		}
		else {
			return false;
		}
		
		
	}
	
	
	public boolean isValidEmail(String email) {
		String val =  AdminDao.isValidEmail(email);
		if(val != null) {
			return true;
		}
		else {
			return false;
		}
	}

	public int getUserId(String email) {
		int userId = AdminDao.getUserId(email);
		return userId;
	}
	
}

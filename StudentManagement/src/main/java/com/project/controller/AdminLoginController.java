package com.project.controller;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.entity.Admin;
import com.project.service.AdminDaoImpl;

@RestController
@RequestMapping("/Admin")
public class AdminLoginController {

	@Autowired
	private AdminDaoImpl adminDaoImpl;

	@PostMapping("/Login")
	public boolean isValidAdmin(@RequestBody Admin isValidAdmin) {
		boolean isValidEmail= adminDaoImpl.isValidEmail(isValidAdmin.getEmail());
		if(isValidEmail) {
			try {
				String inputPassword = isValidAdmin.getPassword();
				  
	            // Static getInstance method is called with hashing MD5
	            MessageDigest md = MessageDigest.getInstance("MD5");
	  
	            // digest() method is called to calculate message digest
	            //  of an input digest() return array of byte
	            byte[] messageDigest = md.digest(inputPassword.getBytes());
	  
	            // Convert byte array into signum representation
	            BigInteger no = new BigInteger(1, messageDigest);
	  
	            // Convert message digest into hex value
	            String hashtext = no.toString(16);
	            
	            while (hashtext.length() < 32) {
	                hashtext = "0" + hashtext;
	            }
	            
	            boolean isValidUser = adminDaoImpl.isValidAdmin(isValidAdmin.getEmail(),hashtext);
	           if(isValidUser) {
	        	   return true;
	           }
	           
	        } 
	  
	        // For specifying wrong message digest algorithms
	        catch (NoSuchAlgorithmException e) {
	            throw new RuntimeException(e);
	        }
			
		}
		
		return false;
	}

}

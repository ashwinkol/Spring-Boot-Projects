package com.project.controller;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.pojo.UserLoginDetails;
import com.project.service.StudentsDaoImpl;
import com.project.service.TeacherDaoImpl;

@RestController
@RequestMapping("/Login")
public class LoginController {

	@Autowired
	private StudentsDaoImpl studentDaoImpl;

	@Autowired
	private TeacherDaoImpl teacherDaoImpl;

	@PostMapping("/CheckUser")
	public void loginUser(@RequestBody UserLoginDetails userDetails) {
		boolean validUserEmail = studentDaoImpl.findStudentByEmail(userDetails.getEmail());
		if(validUserEmail) {
		try {
			String inputPassword = userDetails.getPassword();
			  
            // Static getInstance method is called with hashing MD5
            MessageDigest md = MessageDigest.getInstance("MD5");
  
            // digest() method is called to calculate message digest
            //  of an input digest() return array of byte
            byte[] messageDigest = md.digest(inputPassword.getBytes());
  
            // Convert byte array into signum representation
            BigInteger no = new BigInteger(1, messageDigest);
  
            // Convert message digest into hex value
            String hashtext = no.toString(16);
            
            System.out.println("Hash Text Password:  "+hashtext);
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
           
        } 
  
        // For specifying wrong message digest algorithms
        catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
		
		}
		else {
			System.out.println("Invalid User Id Or Password!");
		}
		

	}

}

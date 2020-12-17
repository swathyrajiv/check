package com.w.simplilearn.thirdphase.controller;



import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.w.simplilearn.thirdphase.Admin;
import com.w.simplilearn.thirdphase.service.AdminService;
@RestController
@RequestMapping("/login")
@SessionAttributes()
public class AdminController {
	@Autowired
	AdminService service;
	String username;
	String password;
	//Admin admin= new Admin();
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public void login(Admin admin) {
	
		username = admin.getUserName();
		password = admin.getPassword();
		System.out.println(username);
		String pass = updateCredentials(username);
		
		System.out.println(pass);
	}

    
//	For querying from the database using JdbcTemplate
//	 
	    
	    
	
		
		String updateCredentials(String username) {
			
		   System.out.println(username);
		    
			
			return service.updateCredentials(username);
		}
	 
}

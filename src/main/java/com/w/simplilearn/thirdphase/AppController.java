package com.w.simplilearn.thirdphase;


import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
 
@Controller

public class AppController {
     
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public void login(Admin admin) {
	    System.out.println("Username= " + admin.getUserName());
	    System.out.println("Password= " + admin.getPassword());
	}
}
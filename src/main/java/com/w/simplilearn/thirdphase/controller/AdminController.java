package com.w.simplilearn.thirdphase.controller;



import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.w.simplilearn.thirdphase.Admin;
import com.w.simplilearn.thirdphase.Shoes;
import com.w.simplilearn.thirdphase.service.AdminService;
@RestController
//@RequestMapping("/login")
@SessionAttributes()
public class AdminController {
	@Autowired
	AdminService service;
	String username;
	String password;
	
//	@RequestMapping (value = "/login", method = RequestMethod.POST)
//
//	
//	public ModelAndView welcome() {
//	    ModelAndView modelAndView = new ModelAndView();
//	    modelAndView.setViewName("welcome");
//	    return modelAndView;
//	}
			
	
//	@RequestMapping("/")
//	public String index() {
//		return "index.jsp";
//	}
	@RequestMapping (value = "/login", method = RequestMethod.POST)
	public ModelAndView  login(Admin admin) {
	String pass[] = null;
		
		username = admin.getUserName();
		password = admin.getPassword();
		System.out.println(username);
		List<Admin>adminlist = new ArrayList<>();
		
		adminlist =updateCredentials();
		
//		username = adminlist.get(0);
//		password = adminlist.getPassword();
//		password = fetchpassword();
		
		System.out.println(adminlist.get(1));
		
		 ModelAndView modelAndView = new ModelAndView();
		 modelAndView.setViewName("welcome");
		modelAndView.addObject("name", adminlist.get(0));
		modelAndView.addObject("password", adminlist.get(1));
		
		 return modelAndView;
		
		//keytool -genkey -alias selfsigned_localhost_sslserver -keyalg RSA -keysize 2048 -validity 700 -keypass password -storepass password -keystore ssl-server.jks
	 
	}

//		
	List<Admin>  updateCredentials() {
			
		   
			return service.updateCredentials();
		}
		
//		
	@RequestMapping(value ="/addshoesview", method = RequestMethod.GET)
	public ModelAndView addshoesview() {
	ModelAndView modelAndView = new ModelAndView();
	 modelAndView.setViewName("addshoes");
	 return modelAndView;
	}
	@RequestMapping(value ="/addshoes", method = RequestMethod.POST)
	public ModelAndView addShoes(Shoes shoe) {
		int value ;
		String brandName = null;
		String size = null;
		String color = null;
		String type = null;
		BigDecimal price;
		brandName = shoe.getBrandName();
		size = shoe.getSize();
		color = shoe.getColor();
		type = shoe.getType();
		price = shoe.getPrice();
		value = updateShoes(brandName, size, color, type,price);
		System.out.println(value);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("addshoes");
		return modelAndView;
		
	}
	int updateShoes(String brandName,String size,String color, String type,BigDecimal price) {
		return service.updateShoes(brandName,size,color,type,price);
	}
}

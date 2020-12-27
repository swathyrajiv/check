package com.w.simplilearn.thirdphase.controller;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.w.simplilearn.thirdphase.Shoes;
import com.w.simplilearn.thirdphase.User;
import com.w.simplilearn.thirdphase.service.AdminService;

@RestController
public class UserController {
	@Autowired
	AdminService service;
	static int sesid;
	
//	
@RequestMapping(value ="/home")
public ModelAndView homeView() {
	ModelAndView modelAndView = new ModelAndView();
	modelAndView.setViewName("userhome");
	return modelAndView;
}
@RequestMapping(value = "/usersearch",method = RequestMethod.POST)
public ModelAndView getShoe(Shoes shoes) {
	String search_key = null;
	search_key =shoes.getType();
	
	List<Shoes> shoe = new ArrayList<>();
	shoe = getShoe(search_key);
	if(shoe.isEmpty()) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("invalid");
		return modelAndView;
	}else {
		ModelAndView modelAndView = new ModelAndView();
	modelAndView.addObject("shoes", shoe);
	modelAndView.setViewName("displayshoes");
	return modelAndView;
	}
}
public List<Shoes> getShoe(String search_key) {
	return service.getShoe(search_key);
}
@RequestMapping(value = "/saveshoes",method = RequestMethod.POST)
public ModelAndView saveshoes(Shoes shoes,User user) {
	sesid = shoes.getSesproduct_id();
	ModelAndView modelAndView = new ModelAndView();
	modelAndView.addObject("id", sesid);
	modelAndView.setViewName("userregistration");
	return modelAndView;
}
public  int updatePurchase(String username, String address, String emailid, String phoneno,String color,String brandname, String type,String size,LocalDate date,BigDecimal price) {
	
	return service.updatePurchase(username,address,emailid,phoneno,color,brandname,type,size,date,price);
}
public  List<Shoes> getSelShoe(int id) {
	
	return service.getSelShoe(id);
}

@RequestMapping(value ="/userregistration" ,method = RequestMethod.POST)
public ModelAndView userregistersuccess(Shoes shoes,User user) {
	List<Shoes>shoe = new ArrayList<>();
	String username = null;;
	 String address = null;
	 String emailid = null;
	 String phoneno  = null;
	 LocalDate date = LocalDate.now();
    System.out.println("Current date: "+date);
    
	 username = user.getUsername();
	 address = user.getAddress();
	 emailid = user.getEmailid();
	 phoneno = user.getPhoneno();
	 shoe=getSelShoe(sesid);
	 System.out.println(sesid);
	System.out.println(shoe.get(0).getSize());
	System.out.println(shoe.get(0).getPrice());
	
	int ret =updatePurchase(username,address, emailid, phoneno,shoe.get(0).getColor(),shoe.get(0).getBrandName(),shoe.get(0).getType(),shoe.get(0).getSize(),date,shoe.get(0).getPrice());
	System.out.println(ret);
	System.out.println(shoe);
	System.out.println(sesid);
	
	ModelAndView modelAndView = new ModelAndView();
	modelAndView.addObject("shoes", shoe);
	modelAndView.setViewName("usregsuccess");
	return modelAndView;
}
@RequestMapping(value ="/paymentsubmit" ,method = RequestMethod.GET)
public ModelAndView userregisterationsuc(Shoes shoes, User user) {
	 ModelAndView modelAndView = new ModelAndView();
	 
		modelAndView.setViewName("paymentsubmit");
		return modelAndView;
}
}

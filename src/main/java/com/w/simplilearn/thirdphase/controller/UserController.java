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
	static String[] upcolor;
//	static int[] sesid = new int[500];
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
//	for (int i=0;i<shoe.size();i++) {
//		System.out.println(shoe.get(i).getSize());
//		System.out.println(shoe.get(i).getColor());
//		System.out.println(shoe.get(i).getBrandName());
//		
//	}

	ModelAndView modelAndView = new ModelAndView();
	modelAndView.addObject("shoes", shoe);
	//modelAndView.addObject("color", attributeValue)
	modelAndView.setViewName("displayshoes");
	return modelAndView;
}
public List<Shoes> getShoe(String search_key) {
	return service.getShoe(search_key);
}
@RequestMapping(value = "/saveshoes",method = RequestMethod.POST)
public ModelAndView saveshoes(Shoes shoes,User user) {
	sesid = shoes.getSesproduct_id();
	
	
//	List<Shoes>shoe = new ArrayList<>();
//	for(int i = 0;i <sesid.length;i++) {
//		//sesid =shoes.getSesproduct_id();
//System.out.println(sesid[i]);
//	}
//	shoe=getSelShoe(sesid);
//	String color = null;
//	String size = null;
//	String brandname = null;
//	String type = null;
//	color = shoe.get(0).getColor();
//	size = shoe.get(0).getSize();
//	brandname = shoe.get(0).getBrandName();
//	type = shoe.get(0).getType();
//	
//	String username = null;;
//	 String address = null;
//	 String emailid = null;
//	 String phoneno  = null;
//	 LocalDate date = LocalDate.now();
//     System.out.println("Current date: "+date);
//     
//	 username = user.getUsername();
//	 address = user.getAddress();
//	 emailid = user.getEmailid();
//	 phoneno = user.getPhoneno();
//	 
//	int retid = updatePurchase(username,address, emailid, phoneno,color,brandname,type,size,sesid,date);
//	System.out.println(sesid);
//	System.out.println(retid);
	ModelAndView modelAndView = new ModelAndView();
	modelAndView.addObject("id", sesid);
	modelAndView.setViewName("userregistration");
	return modelAndView;
}
public  int updatePurchase(String username, String address, String emailid, String phoneno,String color,String brandname, String type,String size,LocalDate date,BigDecimal price) {
	// TODO Auto-generated method stub
	return service.updatePurchase(username,address,emailid,phoneno,color,brandname,type,size,date,price);
}
public  List<Shoes> getSelShoe(int id) {
	
	return service.getSelShoe(id);
}
//@RequestMapping(value ="/userregistration",method = RequestMethod.POST)
//public ModelAndView userRegistrationView() {
//	ModelAndView modelAndView = new ModelAndView();
//	modelAndView.setViewName("userregistration");
//	return modelAndView;
//}
@RequestMapping(value ="/userregistration" ,method = RequestMethod.POST)
public ModelAndView userregistersuccess(Shoes shoes,User user) {
	List<Shoes>shoe = new ArrayList<>();
//	sesid= shoes.getProduct_id();
	//System.out.println(sesid);
	
	
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
	 //System.out.println("value = "+sesid.length);
	// int ret[] = new int[20];
//	for(int i =0;i<sesid.length;i++) {
//	shoe=getSelShoe(sesid[i]);
	//System.out.println(shoe);
	//System.out.println(shoe.get(i).getColor());
//	color.add(shoe.get(i).getColor());
//	size.add(shoe.get(i).getSize());
//	brandname.add(shoe.get(i).getBrandName());
//	type.add(shoe.get(i).getType());
//	price.add(shoe.get(i).getPrice());
	System.out.println(shoe.get(0).getSize());
	System.out.println(shoe.get(0).getBrandName());
	
	int ret =updatePurchase(username,address, emailid, phoneno,shoe.get(0).getColor(),shoe.get(0).getBrandName(),shoe.get(0).getType(),shoe.get(0).getSize(),date,shoe.get(0).getPrice());
	System.out.println(ret);
	System.out.println(shoe);
	
//	for(int i =0;i<shoe.size();i++) {
//		System.out.println(shoe.get(0).getColor());
//		color.add(shoe.get(i).getColor());
//		size.add(shoe.get(i).getSize());
//		brandname.add(shoe.get(i).getBrandName());
//		type.add(shoe.get(i).getType());
//		price.add(shoe.get(i).getPrice());
//		System.out.println(color);
//	int retid = updatePurchase(username,address, emailid, phoneno,color,brandname,type,size,date,price);
//	System.out.println(retid);
//	}
//	System.out.println(color);
	System.out.println(sesid);
	
	ModelAndView modelAndView = new ModelAndView();
	modelAndView.setViewName("usregsuccess");
	return modelAndView;
	
	
}
}

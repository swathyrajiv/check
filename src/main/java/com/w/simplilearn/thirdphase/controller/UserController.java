package com.w.simplilearn.thirdphase.controller;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.w.simplilearn.thirdphase.Cuizine;
import com.w.simplilearn.thirdphase.Item;
import com.w.simplilearn.thirdphase.User;
import com.w.simplilearn.thirdphase.service.AdminService;

@RestController
public class UserController {
	@Autowired
	AdminService service;
	static int sesid;
	static String username = null;
	static String password = null;
@RequestMapping(value ="/home")
public ModelAndView homeView() {
	ModelAndView modelAndView = new ModelAndView();
	modelAndView.setViewName("userhome");
	return modelAndView;
}
@RequestMapping(value = "/usersearch",method = RequestMethod.POST)
public ModelAndView getFood(Cuizine cuizine) {
	String search_key = null;
	search_key =cuizine.getCuizineName();
	
	List<Cuizine> cuizineList = new ArrayList<>();
	cuizineList = getCuizine(search_key);
	if(cuizineList.isEmpty()) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("invalid");
		return modelAndView;
	}else {
		ModelAndView modelAndView = new ModelAndView();
	modelAndView.addObject("cuizineList", cuizineList);
	modelAndView.setViewName("displayCuizine");
	return modelAndView;
	}
}
@RequestMapping(value = "/searchfood",method = RequestMethod.POST)
public ModelAndView getFoodList(Cuizine cuizine) {
//	String search_key = null;
//	search_key =cuizine.getCuizineName();
	
	List<Cuizine> cuizineList = new ArrayList<>();
	cuizineList = getFoodAll();
	System.out.println(cuizineList+"pl");
	if(cuizineList.isEmpty()) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("invalid");
		return modelAndView;
	}else {
		ModelAndView modelAndView = new ModelAndView();
	modelAndView.addObject("cuizineList", cuizineList);
	modelAndView.setViewName("displayFoodAll");
	return modelAndView;
	}
}
public List<Cuizine> getFoodAll() {
	
	return service.getFoodAll();
}
public List<Cuizine> getCuizine(String search_key) {
	return service.getCuizine(search_key);
}

//public  int updatePurchase(String username, String address, String emailid, String phoneno,String color,String brandname, String type,String size,LocalDate date,BigDecimal price) {
//	
//	return service.updatePurchase(username,address,emailid,phoneno,color,brandname,type,size,date,price);
//}
//public  List<Shoes> getSelShoe(int id) {
//	
//	return service.getSelShoe(id);
//}
//@RequestMapping("/loginuser",method = RequestMethod.POST)
//public ModelAndView loginUser()
//@RequestMapping(value = "/saveshoes",method = RequestMethod.POST)
//public ModelAndView saveshoes(Shoes shoes,User user) {
//	sesid = shoes.getSesproduct_id();
//	ModelAndView modelAndView = new ModelAndView();
//	modelAndView.addObject("id", sesid);
//	modelAndView.setViewName("userregistration");
//	return modelAndView;
//}
//public  int updatePurchase(String username, String address, String emailid, String phoneno,String color,String brandname, String type,String size,LocalDate date,BigDecimal price) {
//	
//	return service.updatePurchase(username,address,emailid,phoneno,color,brandname,type,size,date,price);
//}
//public  List<Shoes> getSelShoe(int id) {
//	
//	return service.getSelShoe(id);
//}
//
@RequestMapping(value ="/loginuser" ,method = RequestMethod.POST)
public ModelAndView userlogin() {
	ModelAndView modelAndView = new ModelAndView();
	modelAndView.setViewName("loginuser");
	return modelAndView;
}
@RequestMapping(value ="/loginuserS" ,method = RequestMethod.POST)
public ModelAndView userloginS(User user) {
	List<User>userloginS = new ArrayList<>();
	username = user.getUsername();
	password = user.getPassword();
	userloginS = userloginS(username,password);
	if(userloginS.isEmpty()) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("invalid");
		return modelAndView;
	}else {
	ModelAndView modelAndView = new ModelAndView();
	modelAndView.setViewName("welcomeuser");
	return modelAndView;
	}
}
public List<User> userloginS(String username, String password) {
	
	return service.userloginS(username,password);
}
@RequestMapping(value ="/registerUser" ,method = RequestMethod.POST)
public ModelAndView userregisteration() {
	ModelAndView modelAndView = new ModelAndView();
	modelAndView.setViewName("userregistration");
	return modelAndView;
}
@RequestMapping(value ="/userregistration" ,method = RequestMethod.POST)
public ModelAndView userregistersuccess(User user) {
//	List<Shoes>shoe = new ArrayList<>();
	
	 String address = null;
	 String emailid = null;
	 String phoneno  = null;
//	 String userId = null;
	
	 List<User> selectUserid = new ArrayList<>();
//	 LocalDate date = LocalDate.now();
//    System.out.println("Current date: "+date);
    
    password = user.getPassword();
	 username = user.getUsername();
	 address = user.getAddress();
	 emailid = user.getEmailid();
	 phoneno = user.getPhoneno();
	 
//	 System.out.println(sesid);
//	System.out.println(shoe.get(0).getSize());
//	System.out.println(shoe.get(0).getPrice());
	
//	int ret =updatePurchase(username,address, emailid, phoneno,shoe.get(0).getColor(),shoe.get(0).getBrandName(),shoe.get(0).getType(),shoe.get(0).getSize(),date,shoe.get(0).getPrice());
//	System.out.println(ret);
//	System.out.println(shoe);
//	System.out.println(sesid);
	int ret = insertUser(username,emailid,address,phoneno,password);
//	selectUserid = selectuserid(username,password);
	System.out.println(selectUserid+"id");
	if(ret == 1) {
			ModelAndView modelAndView = new ModelAndView();
	modelAndView.addObject("username", username);
	modelAndView.setViewName("welcomeuser");
	return modelAndView;}
	else {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("invalid");
		return modelAndView;
		
	}
}
//public List<User>  selectuserid(String username, String password) {
//	
//	return service.selectuserid(username,password);
//}
@RequestMapping(value ="/payment" ,method = RequestMethod.POST)
public ModelAndView userregisterationsuc() {
	 ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("usregsuccess");
		return modelAndView;
}
public int insertUser(String username, String emailid, String address, String phoneno, String password) {
	
	return service.insertUser(username,emailid,address,phoneno,password);
}
@RequestMapping (value ="/saveitem", method = RequestMethod.POST)
public ModelAndView saveCuizine(Cuizine cuizine,User user) {
	int[]selid;
	ModelAndView modelAndView = new ModelAndView();
	List<Item> item = new ArrayList<>();
	List<Item> fetchdetails = new ArrayList<>();
	selid = cuizine.getSelid();
	sesid = cuizine.getSesproduct_id();
	System.out.println(username+"un");
	System.out.println(password+"pw");
	for(int i=0;i<selid.length;i++) {
//	System.out.println(sesid);
	item = update(selid[i],username,password);
	System.out.println(selid[i]+"ll");
	System.out.println(item);
	
	//modelAndView.addObject("item", item)
	}
	fetchdetails = fetchdetails(username,password);
	modelAndView.addObject("fetchdetails", fetchdetails);
	modelAndView.setViewName("selected_item");
	return modelAndView;
}
public List<Item> fetchdetails(String username, String password) {
	
	return service.fetchdetails(username,password);
}
public  List<Item> update(int i,String username,String password) {
	
	return service.update(i,username,password);
}
@RequestMapping(value ="/paymentsubmit", method =RequestMethod.GET)
public ModelAndView payment() {
	ModelAndView modelAndView = new ModelAndView();
	modelAndView.setViewName("paymentsubmit");
	return modelAndView;
}
}

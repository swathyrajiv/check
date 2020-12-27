package com.w.simplilearn.thirdphase.controller;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import com.w.simplilearn.thirdphase.Admin;
import com.w.simplilearn.thirdphase.Shoes;
import com.w.simplilearn.thirdphase.User;
import com.w.simplilearn.thirdphase.service.AdminService;
@RestController
//@RequestMapping("/login")
@SessionAttributes()
public class AdminController {
	@Autowired
	AdminService service;
	String username;
	String password;
	String daten;
	static String name;
	@RequestMapping (value = "/logout", method = RequestMethod.GET)
	public ModelAndView logout() {
	    ModelAndView modelAndView = new ModelAndView();
	    modelAndView.setViewName("index");
	    return modelAndView;
	}	
	@RequestMapping (value = "/login", method = RequestMethod.POST)
	public ModelAndView  login(Admin admin) {
	
		username = admin.getUserName();
		password = admin.getPassword();
		System.out.println(username);
		System.out.println(password);
		List<Admin>adminlist = new ArrayList<>();
		
		adminlist =updateCredentials();
		name =adminlist.get(0).getUserName();
//		
		if(username.equals(adminlist.get(0).getUserName())&& password.equals(adminlist.get(0).getPassword())) {
			ModelAndView modelAndView = new ModelAndView();
			 modelAndView.setViewName("welcome");
			modelAndView.addObject("name", adminlist.get(0).getUserName());
			
			 return modelAndView;
		}
		else 
		{
			ModelAndView modelAndView = new ModelAndView();
			 modelAndView.setViewName("error");
			 return modelAndView;
		}
	}	
	List<Admin>  updateCredentials() {
		
			return service.updateCredentials();
		}
	@RequestMapping (value = "/log", method = RequestMethod.GET)
	public ModelAndView welcome(Admin admin) {
	    ModelAndView modelAndView = new ModelAndView();
	    modelAndView.addObject("name", name);
	    modelAndView.setViewName("welcome");
	    return modelAndView;
	}
		
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
		if(value ==1) {
		System.out.println(value);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("addshoes");
		return modelAndView;
		} else {
			ModelAndView modelAndView = new ModelAndView();
			modelAndView.setViewName("invalid");
			return modelAndView;
		}
		
	}
	int updateShoes(String brandName,String size,String color, String type,BigDecimal price) {
		return service.updateShoes(brandName,size,color,type,price);
	}
	@RequestMapping(value ="/changepassword", method = RequestMethod.GET)
	public ModelAndView changePassword() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("changepassword");
		return modelAndView;
		
	}
	@RequestMapping(value ="/changepasswordedit", method = RequestMethod.POST)
	public ModelAndView changePasswordedit(Admin admin) {
		String userName ;
		String password;
		String cpassword;
		userName = admin.getUserName();
		password = admin.getPassword();
		int ret = updateup(userName,password);
		
if(ret==1) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("name", name);
		modelAndView.setViewName("welcome");
		return modelAndView;
}else {
	ModelAndView modelAndView = new ModelAndView();
	modelAndView.setViewName("invalid");
	return modelAndView;
}
	}
	public int updateup(String userName, String password) {
		
		return service.updateup(userName,password);
	}
	
	@RequestMapping (value ="/viewpurchasehistory")
	public ModelAndView viewPurchaseHistory() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("viewpurchase");
		return modelAndView;
		
	}
	@RequestMapping(value = "/viewhistory", method = RequestMethod.POST)
		public ModelAndView viewHistory(User user, Shoes shoe) {
		List<Shoes>updaList = new ArrayList<>();
		List<User>updaListUser = new ArrayList<>();
		daten = shoe.getDaten();
		updaList =fetchDateHistory(daten);
		updaListUser = fetchDateHistory2(daten);
		if(updaList.isEmpty()) {
			ModelAndView modelAndView = new ModelAndView();
			modelAndView.setViewName("invalid");
			return modelAndView;
		}else {
		System.out.println(updaList);
			System.out.println(daten);
			ModelAndView modelAndView = new ModelAndView();
			modelAndView.setViewName("viewhistorypage");
			modelAndView.addObject("updalist", updaList);
			modelAndView.addObject("updalistuser",updaListUser);
			return modelAndView;
		}
	}
	public List<User> fetchDateHistory2(String daten) {
		return service.fetchDateHistory2(daten);
	}

	public List<Shoes> fetchDateHistory(String daten) {
		return service.fetchDateHistory(daten);
		
	}
	
}

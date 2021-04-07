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
import com.w.simplilearn.thirdphase.Cuizine;
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
	String editCuizine;
	static String name;
	int updateCuizId,delCuizineId;
	static String success ="updated the data successfully";
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
		
	@RequestMapping(value ="/addCuizine", method = RequestMethod.GET)
	public ModelAndView addshoesview() {
	ModelAndView modelAndView = new ModelAndView();
	 modelAndView.setViewName("addCuizine");
	 return modelAndView;
	}
	@RequestMapping(value ="/addcuizineview", method = RequestMethod.POST)
	public ModelAndView addCuizine(Cuizine cuizine) {
		int value ;
		String cuizineName = null;
		String cuizineType = null;
		String vegornonveg = null;
		String vegan = null;
		BigDecimal price;
		cuizineName = cuizine.getCuizineName();
		cuizineType = cuizine.getCuizineType();
		vegornonveg = cuizine.getVegornonveg();
		vegan = cuizine.getVegan();
		price = cuizine.getPrice();
		value = updateCuizine(cuizineName,cuizineType,vegornonveg,vegan,price);
		if(value ==1) {
		System.out.println(value);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("success",success);
		modelAndView.setViewName("addCuizine");
		return modelAndView;
		} else {
			ModelAndView modelAndView = new ModelAndView();
			modelAndView.setViewName("invalid");
			return modelAndView;
		}
		
	}
	int updateCuizine(String cuizineName,String cuizineType,String vegornonveg, String vegan,BigDecimal price) {
		return service.updateCuizine(cuizineName,cuizineType,vegornonveg,vegan,price);
	}
	@RequestMapping(value ="/editCuizineD")
	public ModelAndView editCuizine() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("editCuizine");
		return modelAndView;
	}
	@RequestMapping(value ="/editCuizineDetailsMap",method = RequestMethod.POST)
	public ModelAndView editCuizine(Cuizine cuizine) {
		List<Cuizine>fetchCuizineList = new ArrayList<>();
		editCuizine = cuizine.getEditCuizine();
		System.out.println(editCuizine+"nn");
		fetchCuizineList = fetchCuizineDetails(editCuizine);
		System.out.println("list"+fetchCuizineList);
		if(fetchCuizineList.isEmpty()) {
			ModelAndView modelAndView = new ModelAndView();
			modelAndView.setViewName("invalid");
			return modelAndView;
		}else {
			System.out.println(fetchCuizineList);
			ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("editCuizineDetails");
			modelAndView.addObject("fetchCuizineList", fetchCuizineList);
			return modelAndView;
		}
		
		
	}
	public List<Cuizine> fetchCuizineDetails(String editCuizine){
		
		return service.fetchCuizineDetails(editCuizine);
	}
	@RequestMapping(value="/editCuiz",method = RequestMethod.POST)
	public ModelAndView editCuizineDetailsMapadd(Cuizine cuizine) {
		ModelAndView modelAndView = new ModelAndView();
		updateCuizId = cuizine.getProduct_id();
		modelAndView.addObject("updateCuizId", updateCuizId);
		System.out.println(updateCuizId+"pp");
		modelAndView.setViewName("editCuizineAdd");
		return modelAndView;
	}
	@RequestMapping(value="/editCuizineAdd",method = RequestMethod.POST)
	public ModelAndView editCuizineAddDb(Cuizine cuizine) {
		
		updateCuizId = cuizine.getProduct_id();
		String cuizineName = null;
		String cuizineType = null;
		String vegornonveg = null;
		String vegan = null;
		BigDecimal price;
		cuizineName = cuizine.getCuizineName();
		cuizineType = cuizine.getCuizineType();
		vegornonveg = cuizine.getVegornonveg();
		vegan = cuizine.getVegan();
		price = cuizine.getPrice();
		System.out.println(updateCuizId+"ii");
		System.out.println(cuizineName+"name");
		System.out.println(cuizineType+"ty");
		int ret = updateCuizineFn(cuizineName,cuizineType,vegornonveg,vegan,price,updateCuizId);
		System.out.println(ret+"ret");
		if(ret == 1) {
			
			ModelAndView modelAndView = new ModelAndView();
			modelAndView.setViewName("editCuizine");
			modelAndView.addObject("success",success);
			return modelAndView;
		}else {
			ModelAndView modelAndView = new ModelAndView();
			modelAndView.setViewName("invalid");
			return modelAndView;
		}
		
		
	}
	public int updateCuizineFn(String cuizineName,String cuizineType,String vegornonveg,String vegan,BigDecimal price,int updateCuizId) {
		
		return service.updateCuizineFn(cuizineName,cuizineType,vegornonveg,vegan,price,updateCuizId);
	}
	
	
	@RequestMapping(value ="/editCuizineDel", method = RequestMethod.POST)
	public ModelAndView delCuizine(Cuizine cuizine) {
		ModelAndView modelAndView = new ModelAndView();
		delCuizineId =cuizine.getProduct_id();
		System.out.println("delid"+delCuizineId);
		int ret = delCuizine(delCuizineId);
		System.out.println(ret+"retv");
		modelAndView.addObject("success",success);
		modelAndView.setViewName("delCuizne");
		return modelAndView;
		
	}
		
public int delCuizine(int delCuizineId) {
		
		return service.delCuizine(delCuizineId);
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
//	@RequestMapping(value = "/viewhistory", method = RequestMethod.POST)
//		public ModelAndView viewHistory(User user, Cuizine cuizine) {
//		List<Cuizine>updaList = new ArrayList<>();
//		List<User>updaListUser = new ArrayList<>();
//		daten = cuizine.getDaten();
//		updaList =fetchDateHistory(daten);
//		updaListUser = fetchDateHistory2(daten);
//		if(updaList.isEmpty()) {
//			ModelAndView modelAndView = new ModelAndView();
//			modelAndView.setViewName("invalid");
//			return modelAndView;
//		}else {
//		System.out.println(updaList);
//			System.out.println(daten);
//			ModelAndView modelAndView = new ModelAndView();
//			modelAndView.setViewName("viewhistorypage");
//			modelAndView.addObject("updalist", updaList);
//			modelAndView.addObject("updalistuser",updaListUser);
//			return modelAndView;
//		}
//	}
//	public List<User> fetchDateHistory2(String daten) {
//		return service.fetchDateHistory2(daten);
//	}
//
//	public List<Cuizine> fetchDateHistory(String daten) {
//		return service.fetchDateHistory(daten);
//		
//	}
	
}

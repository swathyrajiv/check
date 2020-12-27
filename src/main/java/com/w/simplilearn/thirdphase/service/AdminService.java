package com.w.simplilearn.thirdphase.service;

import java.math.BigDecimal;
import java.time.LocalDate;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.w.simplilearn.thirdphase.Admin;
import com.w.simplilearn.thirdphase.Shoes;
import com.w.simplilearn.thirdphase.User;
import com.w.simplilearn.thirdphase.dao.AdminDao;


@Service
public class AdminService {

	@Autowired
	AdminDao dao;
	
	public List<Admin> updateCredentials() {
		return dao.updateCredentials();
	}

	public int updateShoes(String brandName, String size, String color, String type,BigDecimal price) {
		
		return dao.updateShoes(brandName,size,color,type,price);
	}

	public List<Shoes> getShoe(String search_key) {
	
	return dao.getShoe(search_key);
}

	public List<Shoes> getSelShoe(int id) {
		
		return dao.getSelShoe(id);
	}

	public int updatePurchase(String username, String address, String emailid, String phoneno, String color,
			String brandname, String type,String size,LocalDate date,BigDecimal price) {
		
		return dao.updatePurchase(username,address,emailid,phoneno,color,brandname,type,size,date,price);
	}

	public int updateup(String userName, String password) {
		// TODO Auto-generated method stub
		return dao.updateup(userName,password);
	}

	public List<Shoes>fetchDateHistory(String daten) {
		
		return dao.fetchDateHistory(daten);
	}

	public List<User> fetchDateHistory2(String daten) {
		// TODO Auto-generated method stub
		return dao.fetchDateHistory2(daten);
	}

}

package com.w.simplilearn.thirdphase.service;

import java.math.BigDecimal;
import java.time.LocalDate;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.w.simplilearn.thirdphase.Admin;
import com.w.simplilearn.thirdphase.Cuizine;
import com.w.simplilearn.thirdphase.Item;
import com.w.simplilearn.thirdphase.User;
import com.w.simplilearn.thirdphase.dao.AdminDao;


@Service
public class AdminService {

	@Autowired
	AdminDao dao;
	
	public List<Admin> updateCredentials() {
		return dao.updateCredentials();
	}

	public int updateCuizine(String cuizineName,String cuizineType,String vegornonveg, String vegan,BigDecimal price) {
		
		return dao.updateCuizine(cuizineName,cuizineType,vegornonveg,vegan,price);
	}
	public List<Cuizine>fetchCuizineDetails(String editCuizine){
		return dao.fetchCuizineDetails(editCuizine);
	}
	public List<Cuizine> getCuizine(String search_key) {
	
	return dao.getCuizine(search_key);
}

//	public List<Cuizine> getSelShoe(int id) {
//		
//		return dao.getSelShoe(id);
//	}
//
//	public int updatePurchase(String username, String address, String emailid, String phoneno, String color,
//			String brandname, String type,String size,LocalDate date,BigDecimal price) {
//		
//		return dao.updatePurchase(username,address,emailid,phoneno,color,brandname,type,size,date,price);
//	}
//
	public int updateup(String userName, String password) {
		// TODO Auto-generated method stub
		return dao.updateup(userName,password);
	}
//
//	public List<Cuizine>fetchDateHistory(String daten) {
//		
//		return dao.fetchDateHistory(daten);
//	}
//
//	public List<User> fetchDateHistory2(String daten) {
//		// TODO Auto-generated method stub
//		return dao.fetchDateHistory2(daten);
//	}

	public int updateCuizineFn(String cuizineName,String cuizineType,String vegornonveg,String vegan,BigDecimal price,int updateCuizId) {
		
		return dao.updateCuizineFn(cuizineName,cuizineType,vegornonveg,vegan,price,updateCuizId);
	}

	public int delCuizine(int delCuizineId) {
		
		return dao.delCuizine(delCuizineId);
	}

	public int insertUser(String username, String emailid, String address, String phoneno, String password) {
		
		return dao.insertUser(username,emailid,address,phoneno,password);
	}

	public List<Cuizine> getFoodAll() {
		// TODO Auto-generated method stub
		return dao.getFoodAll();
	}

	public List<Item> update(int i,String username,String password) {
		
		return dao.update(i,username,password);
	}

	public List<Item> fetchdetails(String username, String password) {
		
		return dao.fetchDetails(username,password);
	}

	public List<User> userloginS(String username, String password) {
		
		return dao.userloginS(username,password);
	}

//	public List<User>  selectuserid(String username, String password) {
//		
//		return dao.selectuserid(username,password);
//	}

}

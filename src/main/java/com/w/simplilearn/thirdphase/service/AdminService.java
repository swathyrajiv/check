package com.w.simplilearn.thirdphase.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.w.simplilearn.thirdphase.dao.AdminDao;


@Service
public class AdminService {

	@Autowired
	AdminDao dao;
	
	public String updateCredentials(String username) {
		return dao.updateCredentials(username);
	}
}

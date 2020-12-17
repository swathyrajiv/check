package com.w.simplilearn.thirdphase.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class AdminDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public String updateCredentials(String username){
		System.out.println(username);
		String qry = "select password from admin where admin_id = ?";
		return jdbcTemplate.queryForObject(qry,new Object[] {username},String.class);
		
	}
}

package com.w.simplilearn.thirdphase.dao;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.w.simplilearn.thirdphase.Admin;
import com.w.simplilearn.thirdphase.Shoes;
import com.w.simplilearn.thirdphase.User;

@Repository
public class AdminDao  {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<Admin> updateCredentials(){
		
		String qry = "select admin_id,password from admin";
		return jdbcTemplate.query(qry,new  AdminMapper());
        
	}
	
	class AdminMapper implements RowMapper<Admin>{

		public Admin mapRow(ResultSet rs, int rowNum) throws SQLException {
			Admin admin = new Admin();
			
//			Map the fields of Mobile with the columns of Table
			admin.setUserName(rs.getString("admin_id"));
			admin.setPassword(rs.getString("password"));
			
			return admin;
		}
}

	public int updateShoes(String brandName, String size, String color, String type,BigDecimal price) {
		String qry = "insert into addshoes( brandName,size,color,type,price)values('"+brandName+"','"+size+"', '"+color+"', '"+type+"','"+price+"' )";
		
		return jdbcTemplate.update(qry);
	}
	

	
	public List<Shoes> getShoe(String search_key) {
		String qry = "select product_id,brandname,size,color,price from addshoes where type = ?";
		@SuppressWarnings("deprecation")
		List<Shoes> shoe = jdbcTemplate.query(
			    qry,
			    new Object[] {search_key},
			    new RowMapper<Shoes>() {
			        public Shoes mapRow(ResultSet rs, int rowNum) throws SQLException {
			            Shoes c = new Shoes();
			            c.setProduct_id(rs.getInt("product_id"));
			            c.setBrandName(rs.getString("brandname"));
			            c.setSize(rs.getString("size"));
			            c.setColor(rs.getString("color"));
			            c.setPrice(rs.getBigDecimal("price"));
			            System.out.println(c.getColor());
			            return c;
			        }
			    });
		return shoe;
		
	}

	public List<Shoes> getSelShoe(int id) {
		
			String qry = "select brandname,size,color,type ,price from addshoes where product_id = ?";
			@SuppressWarnings("deprecation")
			List<Shoes>shoe =jdbcTemplate.query(qry,new Object[] {id},new RowMapper<Shoes>() {
				public Shoes mapRow(ResultSet rs, int rowNum) throws SQLException{
					Shoes c = new Shoes();
					c.setBrandName(rs.getString("brandname"));
					c.setSize(rs.getString("size"));
		            c.setColor(rs.getString("color"));
		            c.setType(rs.getString("type"));
		            c.setPrice(rs.getBigDecimal("price"));
		            return c;
				}
			});
		return shoe;
	}

	public int updatePurchase(String username, String address, String emailid, String phoneno, String color, String brandname, String type,String size,LocalDate date,BigDecimal price) {
		String qry = "insert into purchase_history(username,address,email,phone_no,product_type,product_size,product_color,brand,date,price)values('"+username+"','"+address+"','"+emailid+"','"+phoneno+"','"+type+"','"+size+"','"+color+"','"+brandname+"','"+date+"','"+price+"')";
		 
		 return jdbcTemplate.update(qry);
	}



	public int updateup(String userName, String password) {
		String qry = "update admin set admin_id = ?,password = ? ";
		return jdbcTemplate.update(qry,userName,password);
	}

	public List<Shoes> fetchDateHistory(String daten) {
		String qry = "select product_type,product_size,product_color,brand,price from purchase_history where date =?";
		@SuppressWarnings("deprecation")
		List<Shoes>shoe =jdbcTemplate.query(qry,new Object[] {daten},new RowMapper<Shoes>() {
			public Shoes mapRow(ResultSet rs, int rowNum) throws SQLException{
				Shoes c = new Shoes();
				c.setBrandName(rs.getString("brand"));
				c.setSize(rs.getString("product_size"));
	            c.setColor(rs.getString("product_color"));
	            c.setType(rs.getString("product_type"));
	            c.setPrice(rs.getBigDecimal("price"));
	            return c;
			}
		});
		System.out.println(shoe);
	return shoe;
	
	}



	public List<User> fetchDateHistory2(String daten) {
		String qry = "select username, address,email , phone_no from purchase_history where date = ?";
		@SuppressWarnings("deprecation")
		List<User>user =jdbcTemplate.query(qry,new Object[] {daten},new RowMapper<User>() {
			public User mapRow(ResultSet rs, int rowNum) throws SQLException{
				User c = new User();
				c.setUsername(rs.getString("username"));
				c.setAddress(rs.getString("address"));
	            c.setEmailid(rs.getString("email"));
	            c.setPhoneno(rs.getString("phone_no"));
	            return c;
			}
		});
	return user;
	}


	
}
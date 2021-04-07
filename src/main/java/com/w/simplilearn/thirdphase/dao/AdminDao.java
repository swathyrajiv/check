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
import com.w.simplilearn.thirdphase.Cuizine;
import com.w.simplilearn.thirdphase.Item;
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

	public int updateCuizine(String cuizineName,String cuizineType,String vegornonveg, String vegan, BigDecimal price) {
		String qry = "insert into addshoes( cuizineName,cuizineType,vegornonveg,vegan,price)values('"+cuizineName+"','"+cuizineType+"', '"+vegornonveg+"', '"+vegan+"','"+price+"' )";
		
		return jdbcTemplate.update(qry);
	}
	

	
	public List<Cuizine> getCuizine(String search_key) {
		String qry = "select product_id,cuizineName,cuizineType,vegornonveg,vegan,price from addshoes where cuizineName = ? ";
		@SuppressWarnings("deprecation")
		List<Cuizine> cuiz = jdbcTemplate.query(
			    qry,
			    new Object[] {search_key},
			    new RowMapper<Cuizine>() {
			        public Cuizine mapRow(ResultSet rs, int rowNum) throws SQLException {
			        	Cuizine c = new Cuizine();
			            c.setProduct_id(rs.getInt("product_id"));
			            c.setCuizineName(rs.getString("cuizineName"));
			            c.setCuizineType(rs.getString("cuizineType"));
			            c.setVegan(rs.getString("vegan"));
			           c.setVegornonveg(rs.getString("vegornonveg"));
			           c.setPrice(rs.getBigDecimal("price"));
			            return c;
			        }
			    });
		return cuiz;
		
	}

//	public List<Shoes> getSelShoe(int id) {
//		
//			String qry = "select brandname,size,color,type ,price from addshoes where product_id = ?";
//			@SuppressWarnings("deprecation")
//			List<Shoes>shoe =jdbcTemplate.query(qry,new Object[] {id},new RowMapper<Shoes>() {
//				public Shoes mapRow(ResultSet rs, int rowNum) throws SQLException{
//					Shoes c = new Shoes();
//					c.setBrandName(rs.getString("brandname"));
//					c.setSize(rs.getString("size"));
//		            c.setColor(rs.getString("color"));
//		            c.setType(rs.getString("type"));
//		            c.setPrice(rs.getBigDecimal("price"));
//		            return c;
//				}
//			});
//		return shoe;
//	}
//
//	public int updatePurchase(String username, String address, String emailid, String phoneno, String color, String brandname, String type,String size,LocalDate date,BigDecimal price) {
//		String qry = "insert into purchase_history(username,address,email,phone_no,product_type,product_size,product_color,brand,date,price)values('"+username+"','"+address+"','"+emailid+"','"+phoneno+"','"+type+"','"+size+"','"+color+"','"+brandname+"','"+date+"','"+price+"')";
//		 
//		 return jdbcTemplate.update(qry);
//	}
//
//
//
	public int updateup(String userName, String password) {
		String qry = "update admin set admin_id = ?,password = ? ";
		return jdbcTemplate.update(qry,userName,password);
	}
//
//	public List<Shoes> fetchDateHistory(String daten) {
//		String qry = "select product_type,product_size,product_color,brand,price from purchase_history where date =?";
//		@SuppressWarnings("deprecation")
//		List<Shoes>shoe =jdbcTemplate.query(qry,new Object[] {daten},new RowMapper<Shoes>() {
//			public Shoes mapRow(ResultSet rs, int rowNum) throws SQLException{
//				Shoes c = new Shoes();
//				c.setBrandName(rs.getString("brand"));
//				c.setSize(rs.getString("product_size"));
//	            c.setColor(rs.getString("product_color"));
//	            c.setType(rs.getString("product_type"));
//	            c.setPrice(rs.getBigDecimal("price"));
//	            return c;
//			}
//		});
//		System.out.println(shoe);
//	return shoe;
//	
//	}
//
//
//
//	public List<User> fetchDateHistory2(String daten) {
//		String qry = "select username, address,email , phone_no from purchase_history where date = ?";
//		@SuppressWarnings("deprecation")
//		List<User>user =jdbcTemplate.query(qry,new Object[] {daten},new RowMapper<User>() {
//			public User mapRow(ResultSet rs, int rowNum) throws SQLException{
//				User c = new User();
//				c.setUsername(rs.getString("username"));
//				c.setAddress(rs.getString("address"));
//	            c.setEmailid(rs.getString("email"));
//	            c.setPhoneno(rs.getString("phone_no"));
//	            return c;
//			}
//		});
//	return user;
//	}
//

	public List<Cuizine> fetchCuizineDetails(String editCuizine) {
		
		String qry = "select * from addshoes where cuizineName = ?";
		@SuppressWarnings("deprecation")
		List<Cuizine>cuizine = jdbcTemplate.query(qry,new Object[] {editCuizine}, new RowMapper<Cuizine>() {
			public Cuizine mapRow(ResultSet rs,int rowNum)throws SQLException{
				Cuizine cuiz = new Cuizine();
				cuiz.setProduct_id(rs.getInt("product_id"));
				cuiz.setCuizineName(rs.getString("cuizineName"));
				cuiz.setCuizineType(rs.getString("cuizineType"));
				cuiz.setVegornonveg(rs.getString("vegornonveg"));
				cuiz.setVegan(rs.getString("vegan"));
				cuiz.setPrice(rs.getBigDecimal("price"));
			
				return cuiz;
			}
		});
		return cuizine;
	}

	public int updateCuizineFn(String cuizineName,String cuizineType,String vegornonveg,String vegan,BigDecimal price,int updateCuizId) {
		String qry = "update addShoes set cuizineName = '"+cuizineName+"', cuizineType = '"+cuizineType+"',vegornonveg = '"+vegornonveg+"',vegan = '"+vegan+"',price = '"+price+"' where product_id='"+updateCuizId+"' ";
		  //name='"+e.getName()+"',salary='"+e.getSalary()+"' where id='"+e.getId()+"' ";  
		return jdbcTemplate.update(qry);
	}



	public int delCuizine(int delCuizineId) {
		
	
		String qry = "delete from addShoes where product_id='"+delCuizineId+"'";
		
		return jdbcTemplate.update(qry);
	}



	public int insertUser(String username, String emailid, String address, String phoneno, String password) {
		String qry = "insert into user(userName,emailid,address,phoneno,password)values('"+username+"','"+emailid+"','"+address+"','"+phoneno+"','"+password+"')";
		
		
		return jdbcTemplate.update(qry);
	}



	public List<Cuizine> getFoodAll() {
		
		String qry = "select * from addShoes";
		List<Cuizine>cuizine = jdbcTemplate.query(qry, new RowMapper<Cuizine>() {
		public Cuizine mapRow(ResultSet rs, int rowNum)throws SQLException{
			Cuizine cuiz = new Cuizine();
			cuiz.setProduct_id(rs.getInt("product_id"));
			cuiz.setCuizineName(rs.getString("cuizineName"));
			cuiz.setCuizineType(rs.getString("cuizineType"));
			cuiz.setVegornonveg(rs.getString("vegornonveg"));
			cuiz.setVegan(rs.getString("vegan"));
			cuiz.setPrice(rs.getBigDecimal("price"));
		
			return cuiz;
		}
	});
	return cuizine;
}



	public List<Item>  update(int i,String username,String password) {
		String qry = "select cuizineName,price from addShoes where product_id = '"+i+"'";
		List<Item>item = jdbcTemplate.query(qry, new RowMapper<Item>() {
			public Item mapRow(ResultSet rs, int rowNum)throws SQLException{
				final String cuizinetemp1;
				BigDecimal tempPrice;
				Item item = new Item();
				
				item.setCuizineName(rs.getString("cuizineName"));
				item.setPrice(rs.getBigDecimal("price"));
				cuizinetemp1 = rs.getString("cuizineName");
				tempPrice = rs.getBigDecimal("price");
				
				System.out.println(cuizinetemp1+"ct");
				System.out.println(tempPrice+"tp");
				String query2 ="insert into selected_product(cuizineName,price,userName,password)values('"+cuizinetemp1+"','"+tempPrice+"','"+username+"','"+password+"')";
				jdbcTemplate.update(query2);
				return item;
			}
			
		});
		
	return item;	
	}



	public List<Item> fetchDetails(String username, String password) {
		String qry = "select cuizineName,price from selected_product where username = ? and password =?";
		@SuppressWarnings("deprecation")
		List<Item> item = jdbcTemplate.query(qry, new Object[] {username,password}, new RowMapper<Item>(){
			public Item mapRow(ResultSet rs, int rowNum)throws SQLException{
				Item item = new Item();
				item.setCuizineName(rs.getString("cuizinename"));
				item.setPrice(rs.getBigDecimal("price"));
				return item;

		}
		});
		return item;
	}



	public List<User>userloginS(String username, String password) {
		String qry = "select username,password from user where username =? and password = ?";
		@SuppressWarnings("deprecation")
		List<User> user = jdbcTemplate.query(qry, new Object[] {username,password}, new RowMapper<User>(){
			public User mapRow(ResultSet rs, int rowNum)throws SQLException{
				User user = new User();
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				return user;
			}
		});
		return user;
	}



//	public List<User> selectuserid(String username, String password) {
//		String qry = "select userid from user where username = ? and password =?";
//		@SuppressWarnings("deprecation")
//		List<User>user = jdbcTemplate.query(qry,new Object[] {username,password}, new RowMapper<User>() {
//			public User mapRow(ResultSet rs, int rowNum)throws SQLException{
//				User user = new User();
//				user.setUserId(rs.getString("userid"));
//				return user;
//			}
//		});
//		return user;
//	}
}
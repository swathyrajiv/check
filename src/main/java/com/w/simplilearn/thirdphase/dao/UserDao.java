//package com.w.simplilearn.thirdphase.dao;
//
//import java.sql.ResultSet;
//import java.sql.SQLException;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.jdbc.core.RowMapper;
//import org.springframework.stereotype.Repository;
//
//import com.w.simplilearn.thirdphase.Shoes;
//import com.w.simplilearn.thirdphase.User;
//@Repository
//public class UserDao extends  JdbcTemplate{
//	@Autowired
//	private JdbcTemplate jdbcTemplate;
//	
//		String qry = "select brandname,size,color from addshoes where type = ?";
//		 @SuppressWarnings("deprecation")
//		public Shoes getShoe(String search_key) {
//		        return (Shoes) queryForObject(qry, new Object[] { search_key },
//		             new RowMapper<Shoes>() {
//		                 @Override
//		                 public Shoes mapRow(ResultSet rs, int rowNumber) {
//		                	 Shoes shoe = new Shoes();
//		                     try {
//								shoe.setBrandName(rs.getString("brandname"));
//							
//		                     shoe.setSize(rs.getString("size"));
//		                     shoe.setColor(rs.getString("color"));
//		                     // set other properties
//		                     } catch (SQLException e) {
//									// TODO Auto-generated catch block
//									e.printStackTrace();
//								}
//		                     return shoe;
//		                 }
//
//						
//		             });
//		
//		
//	}
//		
//
//}

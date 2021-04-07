package com.w.simplilearn.thirdphase;

public class User {
	private String username;
	private String address;
	private String emailid;
	private String phoneno;
	private String userId;
	private String password;
	
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmailid() {
		return emailid;
	}
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
	public String getPhoneno() {
		return phoneno;
	}
	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}
	public User(String username, String address, String emailid, String phoneno,String userId,String password) {
		super();
		this.username = username;
		this.address = address;
		this.emailid = emailid;
		this.phoneno = phoneno;
		this.userId = userId;
		this.password = password;
	}
	public User() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return "User [username=" + username + ", address=" + address + ", emailid=" + emailid + ", phoneno=" + phoneno
				+ ", userId=" + userId + ", password=" + password + "]";
	}

}

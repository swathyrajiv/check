package com.w.simplilearn.thirdphase;


	import java.util.ArrayList;
	import java.util.List;
	 
	public class ContactBusiness {
	    public List<Contact> getContactList() {
	        List<Contact> listContact = new ArrayList<>();
	         
	        listContact.add(new Contact("kmdk" ,"marry.john@gmail.com", "USA"));
	        listContact.add(new Contact( "mkmdk","tomsmith@outlook.com", "England"));
	        listContact.add(new Contact("njcd","john123@yahoo.com", "Australia"));
	        listContact.add(new Contact( "kdkc","sivakrishna@gmail.com", "India"));
	         
	        return listContact;
	    }
}

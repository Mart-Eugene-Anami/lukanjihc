package com.eugene.hospitalmanagementsystem.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eugene.hospitalmanagementsystem.daos.patientdao;
import com.eugene.hospitalmanagementsystem.daos.userdao;
import com.eugene.hospitalmanagementsystem.models.Patient;
import com.eugene.hospitalmanagementsystem.models.User;
@Service
public class userservice {
	
	@Autowired
	userdao userdao;
	
	public void addUser(User user) {
		userdao.save(user);}
	
	public User getByusernumber(String usernumber) {
			return userdao.getByusernumber(usernumber);
			
		}
	     public List<User> getAllusers(){
	    	 return userdao.getAllUserRecords();
	     }
}

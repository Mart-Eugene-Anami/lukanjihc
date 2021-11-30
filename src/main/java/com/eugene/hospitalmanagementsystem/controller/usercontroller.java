package com.eugene.hospitalmanagementsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.eugene.hospitalmanagementsystem.models.Patient;
import com.eugene.hospitalmanagementsystem.models.User;
import com.eugene.hospitalmanagementsystem.services.userservice;
@Controller
public class usercontroller {
	
	@Autowired
	userservice userservice;
	
	
	@GetMapping(value="/newUser")
	public String getUserForm(Model model) {
		User user =new User();
		model.addAttribute(user);
		return "userForm";
		
	}
	@PostMapping(value="/signup")
	public String registerUser(@ModelAttribute("user")User user) {
		userservice.addUser(user);
		return "redirect:userpage/"+ user.getUsernumber();
		}
	
	@GetMapping(value="/userpage/{usernumber}")
	public String viewPatientPage(Model model, @PathVariable String usernumber) {
		User user=userservice.getByusernumber(usernumber);
		model.addAttribute("user", user);
		return "userpage";
	}
	
	@PostMapping("/searchUser")
	public String getUser(Model model, @RequestParam String usernumber) {
		User user=userservice.getByusernumber(usernumber);
		model.addAttribute(user);
		return "userpage";
	
	}
	@GetMapping("/userManagement")
	public String manageUsers(Model model) {
	List<User> userList=userservice.getAllusers();
	model.addAttribute("userList", userList);
	return "userManagementHome";
	}
	@GetMapping("/editUser/{usernumber}")
	public String userEditing(Model model, @PathVariable String usernumber) {
		User user=userservice.getByusernumber(usernumber);
		model.addAttribute("user", user);
		return "userForm";
	}



}

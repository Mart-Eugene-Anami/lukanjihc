package com.eugene.hospitalmanagementsystem.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.eugene.hospitalmanagementsystem.models.Labform;
import com.eugene.hospitalmanagementsystem.models.Patient;
import com.eugene.hospitalmanagementsystem.models.triage;
import com.eugene.hospitalmanagementsystem.services.labservice;

@Controller
public class MainController {
	@Autowired
	com.eugene.hospitalmanagementsystem.services.patientservice patientservice;
	@Autowired
	com.eugene.hospitalmanagementsystem.services.triageservice triageservice;
	@Autowired
	labservice labservice;
	
	@RequestMapping("/")
	public String mainHome() {
		return "index";
	}
	
	
	
	
	
	
	@GetMapping("/fetchFinanceHome")
	public String getFinanceHome() {
		return "financeHome";
	}
	@GetMapping("/fetchAdminHome")
	public String getAdminHome() {
		return "adminHome";
	}
	
	@GetMapping("/fetchinventoryHome")
	public String getInventoryHome() {
		return "inventoryHome";}
  
	
	@GetMapping("/fetchOrderHome")
	public String getOrderHome() {
		return "orderhome.jsp";
	}
	
	@GetMapping("/fetchBillingHome")
	public String getBillingHome() {
		return "billinghome";
	}
	@GetMapping("/fetchResourcesHome")
	public String getResourcesHome() {
		return "resourceshome";
	}
	
	
}
	
	
	






















































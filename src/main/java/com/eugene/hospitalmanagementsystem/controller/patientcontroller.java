package com.eugene.hospitalmanagementsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.eugene.hospitalmanagementsystem.models.Order;
import com.eugene.hospitalmanagementsystem.models.Patient;
import com.eugene.hospitalmanagementsystem.models.bill;
import com.eugene.hospitalmanagementsystem.services.patientservice;
@Controller

public class patientcontroller {
	
	@Autowired
	patientservice patientservice;
	@Autowired
	billcontroller billcontroller;
	
	@GetMapping("/fetchReceptionHome")
	public String getReceptionHome(Model model) {
		
		model.addAttribute("patientlist", patientservice.getAllPatientRecords());
		
		return "receptionHome";
	}
	
	@GetMapping(value="/getPatientForm")
    public String getPatientForm(Model model){
    	Patient patient= new Patient();
    	model.addAttribute(patient);
    	return "patientform";
    	
}
@RequestMapping(value="/patientRegistration",method=RequestMethod.POST)    
public String registerNewPatient(@ModelAttribute ("patient")Patient patient) {
	patientservice.addPatient(patient);
	return "redirect:patientpage/"+patient.getPatientnumber();
	
	
}
@RequestMapping(value="/patientpage/{patientnumber}",method= {RequestMethod.POST, RequestMethod.GET})
public String viewPatientPage(Model model, @PathVariable String patientnumber) {
	Patient patient=patientservice.getBypatientnumber(patientnumber);
    model.addAttribute("patient", patient);
	return "patientpage";
}
@PostMapping(value="/searchPatientDetails")
public String getPatient(Model model, @RequestParam String patientnumber) {
Patient patient=patientservice.getBypatientnumber(patientnumber);
model.addAttribute("patient", patient);
return"patientpage";
}
@PostMapping(value="/searchPatient")
public String searchPatients(Model model, @RequestParam String patientname) {
Patient patient=patientservice.getPatients(patientname);
model.addAttribute("patient", patient);
return"patientpage";
}
@PostMapping("/editPatientDetails")
public String editPatientDetails(Model model, @RequestParam String patientnumber) {
	Patient patient=patientservice.getBypatientnumber(patientnumber);
	model.addAttribute(patient);
	return "patientformedit";
}
@GetMapping("/patientManagement")
public ModelAndView patientsHomePage() {
	ModelAndView mv=new ModelAndView("patientManagementHome.jsp");
	List<Patient> patientlist=patientservice.getAllPatientRecords();
	mv.addObject("patientlist", patientlist);
	return mv;
}


}

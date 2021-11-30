package com.eugene.hospitalmanagementsystem.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.eugene.hospitalmanagementsystem.models.Diagnosis;
import com.eugene.hospitalmanagementsystem.models.Patient;
import com.eugene.hospitalmanagementsystem.models.Pharmform;
import com.eugene.hospitalmanagementsystem.models.triage;
@Controller
public class triagecontroller {
	@Autowired
	com.eugene.hospitalmanagementsystem.services.triageservice triageservice;
	@Autowired
	com.eugene.hospitalmanagementsystem.services.patientservice patientservice;
@GetMapping("/triagehome")
public String triageHome(Model model) {
	
	model.addAttribute("patientlist", patientservice.getAllPatientRecords());
	return "triagehome";
}
@GetMapping("/fetchDocHome")
public String getDocHome(Model model) {
	
	model.addAttribute("triagelist", triageservice.getAllTriageRecords());
	
	return "doctorshome";
}
    
    @PostMapping("/fillTriageForm")
    public String addTriage(@ModelAttribute ("triage")triage triage) {
    	Patient patient=patientservice.getBypatientnumber(triage.getPatientid());
    	triage.setPatient(patient);
    	triageservice.addTriage(triage);
    	return "forward:triagepage/"+triage.getTriagenumber();
    }
    
    @PostMapping("/getAllTriagerecords")
	public String retrieveAllRecords(Model model){
		List<triage> triagelist=triageservice.getAllTriageRecords();
		model.addAttribute(triagelist);
		return "triagehome";
	}
    @PostMapping("/getTriagerecord")
	public String retrieveRecord(Model model, @RequestParam String triagenumber) {
    	triage triage=triageservice.getBytriagenumber(triagenumber);
    	model.addAttribute(triage);
    	return "triagepage";
    }
    @RequestMapping(value="/triagepage/{triagenumber}",method= {RequestMethod.POST, RequestMethod.GET})
	public String retrievespecificRecord(Model model, @PathVariable String triagenumber) {
    	triage triage=triageservice.getBytriagenumber(triagenumber);
    	model.addAttribute(triage);
		return "triagepage";
	}
	@GetMapping("/gettriageform")
	public String getTriageForm(Model model) {
		triage triageform=new triage();
		model.addAttribute(triageform);
		return "triageform";
	}
	
	@GetMapping(value="/getTriageForm/{patientnumber}")
	public String getTriage(Model model, @PathVariable String patientnumber) {
		triage triage= new triage();
		model.addAttribute(triage);
		model.addAttribute(patientnumber);
		return "triageform";
	}
	
	@GetMapping(value="/editTriageForm/{patientnumber}")
	public String editTriage(Model model, @PathVariable String patientnumber) {
		triage triage= new triage();
		model.addAttribute(triage);
		model.addAttribute(patientnumber);
		return "triageform";
	}
}



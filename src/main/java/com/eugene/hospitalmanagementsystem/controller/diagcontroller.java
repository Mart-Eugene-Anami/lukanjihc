package com.eugene.hospitalmanagementsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
import com.eugene.hospitalmanagementsystem.services.patientservice;
@Controller
public class diagcontroller {
	@Autowired
	com.eugene.hospitalmanagementsystem.services.diagnosisservice diagnosisservice;
	@Autowired
	patientservice patientservice;
	
	
	@GetMapping(value="/diagnosisManager")
	public String getDiagnosisManager(Model model) {
		List<Diagnosis> diaglist=diagnosisservice.getAllDiagnosisRecords();
		model.addAttribute(diaglist);
		return "diagnosishome";
	}
	@PostMapping(value="/fetchDiagnosisRecord")
	public String getDiagnosisForm(Model model, @RequestParam("diagnosisnumber") String diagnosisnumber) {
		Diagnosis diagnosis=diagnosisservice.getBydiagnosisnumber(diagnosisnumber);
		model.addAttribute(diagnosis);
		return "diagnosispage";
	}
	@PostMapping(value="/fillDiagnosisForm")
	public String inputDiagnosis(@ModelAttribute("diagnosis")Diagnosis diagnosis) {
		Patient patient=patientservice.getBypatientnumber(diagnosis.getPatientid());
		diagnosis.setPatient(patient);
		diagnosisservice.addDiagnosis(diagnosis);
		return "redirect:diagnosispage/"+diagnosis.getDiagnosisnumber();
	}
	@RequestMapping(value="/diagnosispage/{diagnosisnumber}",method= {RequestMethod.POST, RequestMethod.GET})
	public String viewPatientPage(Model model, @PathVariable String diagnosisnumber) {
		Diagnosis diagnosis=diagnosisservice.getBydiagnosisnumber(diagnosisnumber);
		model.addAttribute("diagnosisnumber",diagnosis.getDiagnosisnumber());
	    model.addAttribute("diagnosis", diagnosis);
		return "diagnosispage";
	}
	@GetMapping(value="/getDiagnosisForm")
	public String getDiagnosis(Model model) {
		Diagnosis diag= new Diagnosis();
		model.addAttribute(diag);
		return "diagnosisform";
	}
	@GetMapping(value="/getDiagnosisForm/{patientnumber}")
	public String getDiagnosis(Model model, @PathVariable String patientnumber) {
		Diagnosis diag= new Diagnosis();
		model.addAttribute(diag);
		model.addAttribute(patientnumber);
		return "diagnosisform";
	}
	
	@RequestMapping(value="/editDiagnosisForm/{diagnosisnumber}", method= {RequestMethod.POST, RequestMethod.GET})
	public String editDiagnosis(Model model, @PathVariable String diagnosisnumber) {
		Diagnosis diag=diagnosisservice.getBydiagnosisnumber(diagnosisnumber);
		
		model.addAttribute(diag);
		model.addAttribute("patientnumber",diag.getPatient().getPatientnumber() );
		return "diagnosisform";
	}
	@RequestMapping(value="/editDiagnosisForm", method= {RequestMethod.POST, RequestMethod.GET})
	public String editDiagnosisForm(Model model, @RequestParam String diagnosisnumber) {
		Diagnosis diag=diagnosisservice.getBydiagnosisnumber(diagnosisnumber);
		
		model.addAttribute(diag);
		model.addAttribute("patientnumber",diag.getPatient().getPatientnumber() );
		return "diagnosisform";
	}
}

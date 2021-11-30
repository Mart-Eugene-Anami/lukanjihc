package com.eugene.hospitalmanagementsystem.controller;

import java.util.List;
import java.util.Optional;

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
import com.eugene.hospitalmanagementsystem.models.Item;
import com.eugene.hospitalmanagementsystem.models.Labdetails;
import com.eugene.hospitalmanagementsystem.models.Labform;
import com.eugene.hospitalmanagementsystem.models.Labtests;
import com.eugene.hospitalmanagementsystem.models.Patient;
import com.eugene.hospitalmanagementsystem.models.addLabForm;
import com.eugene.hospitalmanagementsystem.models.addbillitem;
import com.eugene.hospitalmanagementsystem.models.bill;
import com.eugene.hospitalmanagementsystem.services.labservice;
@Controller
public class labcontroller {
	
	@Autowired
	labservice labservice;
	@Autowired
	com.eugene.hospitalmanagementsystem.services.diagnosisservice diagnosisservice;
	@Autowired
	com.eugene.hospitalmanagementsystem.services.testservice testservice;
	@Autowired 
	com.eugene.hospitalmanagementsystem.services.patientservice patientservice;
	
	@GetMapping("/fetchLabHome")
	public String getLabHome(Model model) {
		model.addAttribute("formslist", labservice.getAllLabRecords());
		return "labhome";}
	
	@GetMapping(value="/getLabForm")
	public String getLabForm(Model model) {
	Labform lab= new Labform();
	model.addAttribute(lab);
	return "labform";}
	
	@GetMapping("/getForm/{diagnosisnumber}")
	public String labForm(Model model, @PathVariable String diagnosisnumber) {
		Diagnosis diagnosis=diagnosisservice.getBydiagnosisnumber(diagnosisnumber);
		Labform labform=new Labform();
		model.addAttribute(labform);
		model.addAttribute(diagnosis);
		return "labform";
	}
	
	@PostMapping(value="/fillLabForm")
	public String inputLabForm(Model model, @ModelAttribute("labform")Labform Labform) {
		Diagnosis diagnosis=diagnosisservice.getBydiagnosisnumber(Labform.getDiagnosisnumber());
		Labform.setDiagnosis(diagnosis);
		labservice.saveLabForm(Labform);
		return "forward:labdetailspage/"+Labform.getFormid();}
	
	
	@GetMapping(value="/addTest")
	public String addTest(Model model) {
	Labtests test= new Labtests();
	model.addAttribute(test);
	return "testform";}
	
	@PostMapping(value="/addTest")
	public String fillTestForm(@ModelAttribute("labtests")Labtests labtests) {
		testservice.addTest(labtests);
		return "resourceshome";
	}
	
	
	
	@RequestMapping(value="/editLabForm/{formid}", method= {RequestMethod.POST, RequestMethod.GET})
	public String editLabForm(Model model, @PathVariable String formid) {
		Labform lab=labservice.getByformid(formid);
		model.addAttribute(lab);
		return "labform";
	}

	
	@RequestMapping(value="/labdetailspage/{formid}",method= {RequestMethod.POST, RequestMethod.GET})
	public String viewLabDetailsPage(Model model, @PathVariable String formid) {
		Labform labform=labservice.getByformid(formid);
		model.addAttribute("labform", labform);
		model.addAttribute("formid", labform.getFormid());
		model.addAttribute("Items", labform.getLabtestslist());
	    
		return "labdetailspage";
	}
	
	@RequestMapping(value="/getLabDetailsForm/{formid}",method= {RequestMethod.POST, RequestMethod.GET})
	public String getLabDetailsForm(Model model, @PathVariable String formid) {
		Labform labform=labservice.getByformid(formid);
		Labdetails labdetails =new Labdetails();
		model.addAttribute(labdetails);
		model.addAttribute("formid", labform.getFormid());
		model.addAttribute("Items", labform.getLabtestslist());
	    
		return "labdetailsform";
	}
	
	@GetMapping(value="/addTestItem/{formid}")
	public String addBillItem(Model model, @PathVariable String formid) {
		Labform labform=labservice.getByformid(formid);
		List<Labtests> testslist=testservice.getAllTests();
		addLabForm lab= new addLabForm(testslist, labform);
		model.addAttribute(lab);
		return "addLabForm";
		
	}
	@PostMapping(value="/addTestItem")
	public String addLabItem(@ModelAttribute addLabForm addLabForm, Model model) {
		Labform labform=labservice.getByformid(addLabForm.getFormid());
		Labtests test=testservice.getBytestid(addLabForm.getTestid());
		labform.additem(test);
		labservice.saveLabForm(labform);
		return "redirect:/labdetailspage/"+ labform.getFormid();
	}
	@PostMapping(value="/fetchLabRecord")
	public String getFilledLabForm(Model model, @RequestParam("formid") String formid) {
		Labform labform=labservice.getByformid(formid);
	    model.addAttribute(labform);
	    return "labdetailspage";
		
	}
	@GetMapping(value="/getAllLabrecords")
	public String getAllLabRecords(Model model) {
		List<Labform> testslist=labservice.getAllLabRecords();
		model.addAttribute("testslist", testslist);
		return "allLabRecords";
		
	}


}

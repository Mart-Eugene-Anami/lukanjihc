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

import com.eugene.hospitalmanagementsystem.models.Drug;
import com.eugene.hospitalmanagementsystem.models.Frequency;
import com.eugene.hospitalmanagementsystem.models.Mode;
import com.eugene.hospitalmanagementsystem.services.frequencyservice;
@Controller
public class drugcontroller {
	
	@Autowired
	com.eugene.hospitalmanagementsystem.services.drugservice drugservice;
	@Autowired
	frequencyservice frequencyservice;
	@Autowired 
	com.eugene.hospitalmanagementsystem.services.modeservice modeservice;
	
	@GetMapping(value="/getdrugForm")
	public String getDrug(Model model) {
		Drug drug= new Drug();
		model.addAttribute(drug);
		return "drugform";}

	@PostMapping (value="/filldrugForm")
	public String filldrugForm(@ModelAttribute ("drug")Drug drug) {
		drugservice.addDrug(drug);
		return "redirect:drugpage/"+drug.getDrugidentity();
	}
	@RequestMapping(value="/drugpage/{drugidentity}",method= {RequestMethod.POST, RequestMethod.GET})
	public String viewPharmDetailsPage(Model model, @PathVariable String drugidentity) {
		Drug drug=drugservice.getBydrugidentity(drugidentity);
		model.addAttribute(drug);
		return "drugpage";
	}
	@RequestMapping(value="/updateDrugQuantity/{drugidentity}",method= {RequestMethod.POST, RequestMethod.GET})
    public String updateQuantity(Model model, @PathVariable String drugidentity) {
		Drug drug=drugservice.getBydrugidentity(drugidentity);
		model.addAttribute(drug);
		return "drugform";
	}
	@GetMapping(value="/getallDrugs")
	public ModelAndView getAllDrugs() {
		ModelAndView mv=new ModelAndView("allDrugs.jsp");
		List<Drug> druglist=drugservice.getAllDrugs();
		mv.addObject("druglist", druglist);
		return mv;
		
	}


	@PostMapping("/searchDrug")
	public ModelAndView getDrug(@RequestParam("drugname")String drugname){
		ModelAndView mv=new ModelAndView("drugform.jsp");
		Drug drug=drugservice.getBydrugname(drugname);
		mv.addObject(drug);
		return mv;
	}


	@GetMapping("/inventoryManagement")
	public ModelAndView inventoryHomePage() {
		ModelAndView mv=new ModelAndView("inventoryManagement.jsp");
		List<Drug> druglist=drugservice.getAllDrugs();
		mv.addObject("druglist", druglist);
		return mv;
	}
	@GetMapping(value="/addFrequency")
	public String addFrequency(Model model) {
		Frequency frequency=new Frequency();
		model.addAttribute(frequency);
		return "frequencyform";
	}
	@GetMapping(value="/addMode")
	public String addMode(Model model) {
		Mode mode=new Mode();
		model.addAttribute(mode);
		return "modeform";
	}
	@PostMapping (value="/fillFrequencyForm")
	public String fillFrequencyForm(@ModelAttribute ("frequency")Frequency frequency) {
		frequencyservice.addFrequency(frequency);
		return "resourceshome";
	}
	@PostMapping (value="/fillModeForm")
	public String fillModeForm(@ModelAttribute ("mode")Mode mode) {
		modeservice.addMode(mode);
		return "resourceshome";
	}
	
}

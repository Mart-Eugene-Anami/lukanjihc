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

import com.eugene.hospitalmanagementsystem.models.Drug;
import com.eugene.hospitalmanagementsystem.models.Pharmform;
@Controller
public class pharmcontroller {
	
	@Autowired
	com.eugene.hospitalmanagementsystem.services.pharmservice pharmservice;
	@Autowired
	com.eugene.hospitalmanagementsystem.services.drugservice drugservice;
	
	@GetMapping("/fetchPharmHome")
	public String getPharmHome(Model model) {
		
		model.addAttribute("druglist", pharmservice.getLowQuantities());
		return "pharmHome";
	}
	@GetMapping(value="/getPharmForm")
	public String getPharmForm(Model model) {
	Pharmform pharmform= new Pharmform();
	
	model.addAttribute(pharmform);
	return "pharmform";}
	
	@RequestMapping(value="/getPharmForm/{patientnumber}",method= {RequestMethod.POST, RequestMethod.GET})
    public String newPharmForm(@PathVariable String patientnumber, Model model) {
		Pharmform pharmform= new Pharmform();
		
		model.addAttribute(pharmform);
		model.addAttribute(patientnumber);
		return "pharmform";
	}
	@PostMapping(value="/fillPharmForm")
	public String fillPharmForm(@ModelAttribute("pharmform")Pharmform pharmform) {
		pharmservice.savePharmForm(pharmform);
		return "redirect:pharmdetailspage/"+pharmform.getId();
	}
	@RequestMapping(value="/pharmdetailspage/{id}",method= {RequestMethod.POST, RequestMethod.GET})
	public String viewPharmDetailsPage(Model model, @PathVariable String id) {
		Optional<Pharmform> pharmform=pharmservice.getByid(id);
	    model.addAttribute("pharmform", pharmform);
		return "pharmdetailspage";
	}
	@PostMapping(value="/fetchPharmDetails")
	public String getPharmDetailsPage(Model model, @RequestParam("id") String id) {
		Optional<Pharmform> pharmform=pharmservice.getByid(id);
	    model.addAttribute(pharmform);
	    return "pharmdetailspage";
		
	}
	@GetMapping(value="/getAllPharmRecords")
	public String getAllPharmRecords(Model model) {
		List<Pharmform> formlist=pharmservice.getAllPharmRecords();
		model.addAttribute("formlist", formlist);
		return "allPharmRecords";
		
	}


}




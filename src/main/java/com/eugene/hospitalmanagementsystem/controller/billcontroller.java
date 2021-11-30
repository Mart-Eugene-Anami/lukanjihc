package com.eugene.hospitalmanagementsystem.controller;

import java.util.Date;
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

import com.eugene.hospitalmanagementsystem.models.Diagnosis;
import com.eugene.hospitalmanagementsystem.models.Item;
import com.eugene.hospitalmanagementsystem.models.Patient;
import com.eugene.hospitalmanagementsystem.models.User;
import com.eugene.hospitalmanagementsystem.models.addbillitem;
import com.eugene.hospitalmanagementsystem.models.bill;
import com.eugene.hospitalmanagementsystem.models.receipt;
import com.eugene.hospitalmanagementsystem.services.billservice;
import com.eugene.hospitalmanagementsystem.services.patientservice;
import com.eugene.hospitalmanagementsystem.services.receiptservice;
@Controller

public class billcontroller {
	@Autowired
	billservice billservice;
	@Autowired
	patientservice patientservice;
	@Autowired
	com.eugene.hospitalmanagementsystem.services.itemservice itemservice;
	
	@Autowired
	com.eugene.hospitalmanagementsystem.services.userservice userservice;
	
	@Autowired 
	receiptservice receiptservice;
	
	
	@PostMapping(value="/fillBill")
	public String inputBill(Model model, @ModelAttribute("bill")bill bill) {
		Patient patient=patientservice.getBypatientnumber(bill.getPatientid());
		bill.setPatient(patient);
		billservice.addBill(bill);
		return "forward:billpage/"+bill.getBillnumber();
		
		}
	
	@GetMapping(value="/addbillItem/{billnumber}")
	public String addBillItem(Model model, @PathVariable String billnumber) {
		bill bill=billservice.getBybillnumber(billnumber);
		List<Item> Items= itemservice.getAllBillItems();
		addbillitem  newbillitem= new addbillitem(Items, bill);
		model.addAttribute(newbillitem);
		return "addbillitem";
		
	}
	@PostMapping(value="/addBillItem")
	public String addBillItem(@ModelAttribute addbillitem addbillitem, Model model) {
		bill theBill=billservice.getBybillnumber(addbillitem.getBillnumber());
		Item theItem=itemservice.getByid(addbillitem.getIdentity());
		theBill.additem(theItem);
		
		billservice.addBill(theBill);
		return "redirect:/billpage/"+ theBill.getBillnumber();
	}
	@GetMapping(value="/addBillItem/{billnumber}")
	public String addBillItem(@ModelAttribute addbillitem addbillitem, Model model, @PathVariable String billnumber) {
		bill theBill=billservice.getBybillnumber(addbillitem.getBillnumber());
		Item theItem=itemservice.getByid(addbillitem.getIdentity());
		theBill.additem(theItem);
		billservice.addBill(theBill);
		return "redirect:/billpage/"+ theBill.getBillnumber();
	}
	@PostMapping(value="/fetchBill")
	public String getBill(Model model, @RequestParam("billnumber") String billnumber) {
		bill bill=billservice.getBybillnumber(billnumber);
		model.addAttribute("billnumber", bill.getBillnumber());
		model.addAttribute("Items", bill.getItems());
		model.addAttribute("billtotal", bill.getBilltotal());
		return "billpage";
	}
	@RequestMapping(value="/billpage/{billnumber}", method= {RequestMethod.POST, RequestMethod.GET})
	public String viewBillPage(Model model, @PathVariable String billnumber) {
		bill bill=billservice.getBybillnumber(billnumber);
		model.addAttribute("billnumber", bill.getBillnumber());
		model.addAttribute("Items", bill.getItems());
		model.addAttribute("billtotal", bill.getBilltotal());
		return "billpage";
	}
	@RequestMapping(value="/generateBillReceipt/{billnumber}", method= {RequestMethod.POST, RequestMethod.GET})
	public String generateBillReceipt(Model model, @PathVariable String billnumber) {
		bill bill=billservice.getBybillnumber(billnumber);
		
		
		receipt receipt=new receipt();
		
		
		receipt.setUsernumber(bill.getUser().getUsernumber());
		receipt.setTotal(bill.getBilltotal());
		
		model.addAttribute("receipt", receipt);
		model.addAttribute("billnumber", bill.getBillnumber());
		
		return "billreceipt";
	}
	@PostMapping(value="saveReceipt")
	public String saveReceipt(@ModelAttribute receipt receipt) {
		bill bill=billservice.getBybillnumber(receipt.getBillnumber());
		User  user=userservice.getByusernumber(receipt.getUsernumber());
		receipt.setBill(bill);
		receipt.setStaff(user);
		receiptservice.saveReceipt(receipt);
		return "redirect:/receiptpage/"+ receipt.getReceiptnumber();
	}
	
	@RequestMapping(value="/receiptpage/{receiptnumber}", method= {RequestMethod.POST, RequestMethod.GET})
	public String viewReceiptPage(Model model, @PathVariable String receiptnumber) {
		receipt receipt=receiptservice.getReceipt(receiptnumber);
		
		model.addAttribute(receipt);
		
		return "receiptpage";
	}
	
	@PostMapping (value="/getReceipt")
	public String getReceipt(@RequestParam String receiptnumber, Model model) {
		receipt receipt=receiptservice.getReceipt(receiptnumber);
		model.addAttribute(receipt);
		return "receiptpage";	}
	
	
	
	
	@GetMapping(value="/getBill")
	public String getBill(Model model) {
		bill bill=new bill();
		model.addAttribute(bill);
		return "billform";
	}
	
	@GetMapping(value="/getBill/{patientnumber}")
	public String getBillForm(Model model, @PathVariable String patientnumber) {
		bill bill= new bill();
		model.addAttribute(bill);
		model.addAttribute(patientnumber);
		return "billform";
	}
	
	
	
}

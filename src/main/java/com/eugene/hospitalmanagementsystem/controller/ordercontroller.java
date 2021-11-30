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
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.eugene.hospitalmanagementsystem.daos.orderitemdao;
import com.eugene.hospitalmanagementsystem.models.Diagnosis;
import com.eugene.hospitalmanagementsystem.models.Drug;
import com.eugene.hospitalmanagementsystem.models.Frequency;
import com.eugene.hospitalmanagementsystem.models.Item;
import com.eugene.hospitalmanagementsystem.models.Mode;
import com.eugene.hospitalmanagementsystem.models.Order;
import com.eugene.hospitalmanagementsystem.models.Patient;
import com.eugene.hospitalmanagementsystem.models.User;
import com.eugene.hospitalmanagementsystem.models.addDrug;
import com.eugene.hospitalmanagementsystem.models.addbillitem;
import com.eugene.hospitalmanagementsystem.models.addorderitem;
import com.eugene.hospitalmanagementsystem.models.bill;
import com.eugene.hospitalmanagementsystem.models.orderitem;
import com.eugene.hospitalmanagementsystem.models.orderreceipt;
import com.eugene.hospitalmanagementsystem.models.receipt;
import com.eugene.hospitalmanagementsystem.services.modeservice;
import com.eugene.hospitalmanagementsystem.services.orderitemservice;
import com.eugene.hospitalmanagementsystem.services.orderreceiptservice;
import com.eugene.hospitalmanagementsystem.services.orderservice;
import com.eugene.hospitalmanagementsystem.services.userservice;
@Controller

public class ordercontroller {
	@Autowired
	orderservice orderservice;
	@Autowired
	orderitemservice orderitemservice;
	@Autowired
	orderitemdao orderitemdao;
	@Autowired
	com.eugene.hospitalmanagementsystem.services.frequencyservice frequencyservice;
	@Autowired
	modeservice modeservice;
	@Autowired
	com.eugene.hospitalmanagementsystem.services.patientservice patientservice;
	@Autowired
	com.eugene.hospitalmanagementsystem.services.drugservice drugservice;
	@Autowired 
	userservice userservice;
	@Autowired
	orderreceiptservice orderreceiptservice;
	@GetMapping("/fetchOrderForm")
	public String Order(Model model) {
		Order order=new Order();
		model.addAttribute(order);
		return "orderdetailsform";
		}
	@RequestMapping(value="/fetchOrderItemForm/{ordernumber}", method= {RequestMethod.POST, RequestMethod.GET})
	public String getOrderItemForm(Model model, @PathVariable String ordernumber) {
		List<Drug>druglist=drugservice.getAllDrugs();
		List<Mode>modelist=modeservice.getAllModes();
		List<Frequency> frequencylist=frequencyservice.getAllFrequencies();
		Order order=orderservice.getByordernumber(ordernumber);
		addDrug  newdrugitem= new addDrug(druglist, modelist, frequencylist, order);
		model.addAttribute(newdrugitem);
		return "addDrug";
		/*orderitem orderitem=new orderitem();
		model.addAttribute(orderitem);
		model.addAttribute(ordernumber);
		return "orderitemform";*/
	}
	@GetMapping(value="/fetchOrderForm/{patientnumber}")
	public String getOrderForm(Model model, @PathVariable String patientnumber) {
		Order order= new Order();
		model.addAttribute(order);
		model.addAttribute(patientnumber);
		return "orderdetailsform";
	}
	
	@PostMapping(value="/fillOrderForm")
	public String fillOrder(Model model, @ModelAttribute("order")Order order){
		Patient patient=patientservice.getBypatientnumber(order.getPatientid());
		order.setPatient(patient);
		orderservice.addOrder(order);
		return "forward:fetchOrderItemForm/"+order.getOrdernumber();
		/*return "forward:orderpage/"+order.getOrdernumber();*/
		
		
		}
	@GetMapping(value="/addDrugItem/{ordernumber}")
	public String addDrugItem(Model model, @PathVariable String ordernumber) {
		List<Drug>druglist=drugservice.getAllDrugs();
		List<Mode>modelist=modeservice.getAllModes();
		List<Frequency> frequencylist=frequencyservice.getAllFrequencies();
		Order order=orderservice.getByordernumber(ordernumber);
		addDrug  newdrugitem= new addDrug(druglist, modelist, frequencylist,order);
		model.addAttribute(newdrugitem);
		return "addDrug";
		
	}
	@PostMapping(value="/addDrug")
	public String addDrugItem(@ModelAttribute addDrug addDrug, Model model) {
		Order theOrder=orderservice.getByordernumber(addDrug.getOrdernumber());
		Drug theDrug=drugservice.getBydrugidentity(addDrug.getDrugidentity());
		Frequency theFrequency=frequencyservice.getByFrequencyname(addDrug.getFrequencyname());
		Mode theMode=modeservice.getMode(addDrug.getModeid());
		orderitem orderitem=new orderitem();
		orderitem.setDrug(theDrug);
		orderitem.setDuration(addDrug.getDuration());
		orderitem.setFrequency(theFrequency);
		
		orderitem.setDose(addDrug.getDose());
		orderitem.setItemid(addDrug.getOrderitemid());
		
		orderitemservice.addOrderItem(orderitem);
		
		
		theOrder.additem(orderitem);
		orderservice.addOrder(theOrder);
		
		
		
		
		
				return "redirect:/orderpage/"+ theOrder.getOrdernumber();
	}
	@GetMapping(value="/addorderItem/{ordernumber}")
	public String addOrderItem(Model model, @PathVariable String ordernumber) {
		
		List<Frequency> frequencylist=frequencyservice.getAllFrequencies();
		List<Mode> modelist=modeservice.getAllModes();
		List<Drug>druglist=drugservice.getAllDrugs();
		Order order=orderservice.getByordernumber(ordernumber);
	orderitem  neworderitem= new orderitem();
		model.addAttribute(modelist);
		model.addAttribute(frequencylist);
		model.addAttribute(neworderitem);
		model.addAttribute(order);
		model.addAttribute(druglist);
		return "orderitemform";}
	
	@PostMapping(value="/fillOrderItem")
	public String fillOrderItem(Model model,@ModelAttribute orderitem orderitem) {
		Order theOrder=orderservice.getByordernumber(orderitem.getOrdernumber());
		theOrder.additem(orderitem);
		orderservice.addOrder(theOrder);
		List<Drug>druglist=drugservice.getAllDrugs();
		List<Mode>modelist=modeservice.getAllModes();
		List<Frequency> frequencylist=frequencyservice.getAllFrequencies();
		
		addDrug  newdrugitem= new addDrug(druglist, modelist, frequencylist, theOrder);
		model.addAttribute(newdrugitem);
		return "addDrug";
		
		/*return "forward:/orderpage/"+ theOrder.getOrdernumber();*/
	}
	
	@RequestMapping(value="/orderpage/{ordernumber}",  method= {RequestMethod.POST, RequestMethod.GET})
	public String viewOrderPage(Model model, @PathVariable String ordernumber) {
		Order order=orderservice.getByordernumber(ordernumber);
		model.addAttribute("ordernumber", order.getOrdernumber());
		model.addAttribute("Items", order.getOrderitems());
		model.addAttribute("orderamount", order.getTotalorderamount());
		return "orderpage";
	}
	
	@PostMapping(value="/editOrderForm")
	public ModelAndView editOrder(@RequestParam("ordernumber") String ordernumber) {
	Order order=orderservice.getByordernumber(ordernumber);
	ModelAndView mv=new ModelAndView("editOrderForm.jsp");
	mv.addObject(order);
	return mv;}

	@PostMapping("/searchOrder")
	public String getOrder(Model model,@RequestParam("ordernumber")String ordernumber){
		Order order=orderservice.getByordernumber(ordernumber);
		model.addAttribute("ordernumber", order.getOrdernumber());
		model.addAttribute("Items", order.getOrderitems());
		model.addAttribute("orderamount", order.getTotalorderamount());
		return "orderpage";
	}
	@GetMapping(value="/getallOrders")
	public ModelAndView getAllOrders() {
		ModelAndView mv=new ModelAndView("allOrders.jsp");
		List<Order> orderlist=orderservice.getAllOrders();
		mv.addObject("orderlist", orderlist);
		return mv;
		
	}
	
	@RequestMapping(value="/generateOrderReceipt/{ordernumber}", method= {RequestMethod.POST, RequestMethod.GET})
	public String generateOrderReceipt(Model model, @PathVariable String ordernumber) {
		Order order=orderservice.getByordernumber(ordernumber);
		
		orderreceipt orderreceipt=new orderreceipt();
		
		
		orderreceipt.setUsernumber(order.getOfficername().getUsernumber());
		orderreceipt.setTotal(order.getTotalorderamount());
		
		model.addAttribute("orderreceipt", orderreceipt);
		model.addAttribute("ordernumber", order.getOrdernumber());
		
		return "orderreceipt";
	}
	@PostMapping(value="saveOrderReceipt")
	public String saveOrderReceipt(@ModelAttribute ("orderreceipt") orderreceipt orderreceipt) {
		Order order=orderservice.getByordernumber(orderreceipt.getOrdernumber());
		User  user=userservice.getByusernumber(orderreceipt.getUsernumber());
		orderreceipt.setOrder(order);
		orderreceipt.setStaff(user);
		orderreceiptservice.saveReceipt(orderreceipt);
		return "redirect:/orderreceiptpage/"+ orderreceipt.getReceiptnumber();
	}
	@RequestMapping(value="/orderreceiptpage/{receiptnumber}",  method= {RequestMethod.POST, RequestMethod.GET})
	public String viewOrderReceiptPage(Model model, @PathVariable String receiptnumber) {
		orderreceipt orderreceipt=orderreceiptservice.getByorderreceiptnumber(receiptnumber);
		
		model.addAttribute(orderreceipt);
		return "orderreceiptpage";
	}
	@PostMapping (value="/getOrderReceipt")
	public String getOrderReceipt(@RequestParam String receiptnumber, Model model) {
		orderreceipt orderreceipt=orderreceiptservice.getByorderreceiptnumber(receiptnumber);
		model.addAttribute(orderreceipt);
		
		return "orderreceiptpage";	}
	
	
}

package com.eugene.hospitalmanagementsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.eugene.hospitalmanagementsystem.models.Item;

@Controller
public class itemcontroller {
	@Autowired
	com.eugene.hospitalmanagementsystem.services.itemservice itemservice;
@GetMapping(value="/getItemform")
	public String getItemform(Model model) {
		Item item=new Item();
		model.addAttribute(item);
		return "itemform";
	}
	
	
	public String itemhome(Model model) {
	List<Item> items=itemservice.getAllBillItems();
	model.addAttribute(items);
	return "itemshome";
}
	@PostMapping(value="/addItem")
public String addItem(@ModelAttribute("item")Item item) {
	itemservice.addBillItem(item);
	return "itempage";
}

public String fetchItem(Model model, @RequestParam String identity) {
Item item= itemservice.getByid(identity);
model.addAttribute(item);
return "itempage";

}
}

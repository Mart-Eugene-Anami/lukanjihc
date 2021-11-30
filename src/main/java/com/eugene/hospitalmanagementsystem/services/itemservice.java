package com.eugene.hospitalmanagementsystem.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eugene.hospitalmanagementsystem.daos.itemdao;
import com.eugene.hospitalmanagementsystem.models.Item;
@Service
public class itemservice {
	@Autowired
	itemdao itemdao;
	
	public List<Item> getAllBillItems(){
		 return (List<Item>) itemdao.findAll();
	 }
public void addBillItem(Item item){
	itemdao.save(item);
}
public Item getByid(String identity) {
	return itemdao.getByidentity(identity);
}
}

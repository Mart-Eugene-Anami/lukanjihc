package com.eugene.hospitalmanagementsystem.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eugene.hospitalmanagementsystem.daos.billdao;
import com.eugene.hospitalmanagementsystem.models.Item;
import com.eugene.hospitalmanagementsystem.models.bill;
@Service
public class billservice {
	
	@Autowired 
	billdao billdao;
	
	public void addBill(bill bill) {
		billdao.save(bill);
	}
	public bill getBybillnumber(String billnumber) {
		
		bill bill=billdao.getBybillnumber(billnumber);
		int sum=0;
		for (Item Item: bill.getItems()) {
			sum +=Item.getCost();
		}
		bill.setBilltotal(sum);
		return bill;
	}
	

}

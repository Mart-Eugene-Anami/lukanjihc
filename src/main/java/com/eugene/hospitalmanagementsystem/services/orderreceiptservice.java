package com.eugene.hospitalmanagementsystem.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eugene.hospitalmanagementsystem.daos.orderreceiptdao;
import com.eugene.hospitalmanagementsystem.models.orderreceipt;
@Service
public class orderreceiptservice {
@Autowired
orderreceiptdao receiptdao;

public void saveReceipt(orderreceipt orderreceipt) {receiptdao.save(orderreceipt);}

public orderreceipt getByorderreceiptnumber(String receiptnumber) {
	return receiptdao.getByreceiptnumber(receiptnumber);
	
}

}

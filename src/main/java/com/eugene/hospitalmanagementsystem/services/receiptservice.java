package com.eugene.hospitalmanagementsystem.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eugene.hospitalmanagementsystem.models.receipt;
@Service
public class receiptservice {
@Autowired
com.eugene.hospitalmanagementsystem.daos.receiptdao receiptdao;
 public void saveReceipt(receipt receipt) {
	 receiptdao.save(receipt);
 }
 public receipt getReceipt(String receiptnumber) {
	 return receiptdao.getByreceiptnumber(receiptnumber);
 }
}

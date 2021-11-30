package com.eugene.hospitalmanagementsystem.models;

import java.util.List;

public class addbillitem {
	private List <Item> Items;
	private bill bill;
	
	private String identity;
	private String billnumber;






	public addbillitem() {}
	public addbillitem(List<Item> Items, bill bill) {
		
		this.Items=Items;
		this.bill=bill;
	}
	public List<Item> getItems() {
		return Items;
	}
	public void setItems(List<Item> items) {
		Items = items;
	}
	public bill getBill() {
		return bill;
	}
	public void setBill(bill bill) {
		this.bill = bill;
	}
	public String getIdentity() {
		return identity;
	}
	public void setIdentity(String identity) {
		this.identity = identity;
	}
	public String getBillnumber() {
		return billnumber;
	}
	public void setBillnumber(String billnumber) {
		this.billnumber = billnumber;
	}
}
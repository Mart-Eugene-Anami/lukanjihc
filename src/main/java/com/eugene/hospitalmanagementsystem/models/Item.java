package com.eugene.hospitalmanagementsystem.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="items")
public class Item {
private String itemname;
@Id
private String identity;
private int cost;
@ManyToMany(fetch=FetchType.LAZY, cascade = CascadeType.ALL, mappedBy="items")
private List<bill> bills= new ArrayList<>();




public Item(String itemname, String identity, int cost) {
	
	this.itemname = itemname;
	this.identity = identity;
	this.cost = cost;
}
public Item() {
	
}
public void addBillItem(bill bill) {bills.add(bill);}
public String getItemname() {
	return itemname;
}
public void setItemname(String itemname) {
	this.itemname = itemname;
}
public String getIdentity() {
	return identity;
}
public void setIdentity(String identity) {
	this.identity = identity;
}
public int getCost() {
	return cost;
}
public void setCost(int cost) {
	this.cost = cost;
}
public List<bill> getBills() {
	return bills;
}
public void setBills(List<bill> bills) {
	this.bills = bills;
}

}

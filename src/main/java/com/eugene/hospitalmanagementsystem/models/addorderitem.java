package com.eugene.hospitalmanagementsystem.models;

import java.util.List;

public class addorderitem {
private List<Drug> druglist;
private List<Frequency> frequencies;
private List<Mode> modes;
private int dose;
private String itemid;
private Order order;





public addorderitem() {
	
}





public addorderitem(List<Drug> druglist, List<Frequency> frequencies, List<Mode> modes, Order order) {
	
	this.druglist = druglist;
	this.frequencies = frequencies;
	this.modes = modes;
	
	this.order=order;
}










public List<Drug> getDruglist() {
	return druglist;
}





public void setDruglist(List<Drug> druglist) {
	this.druglist = druglist;
}





public List<Frequency> getFrequencies() {
	return frequencies;
}





public void setFrequencies(List<Frequency> frequencies) {
	this.frequencies = frequencies;
}





public List<Mode> getModes() {
	return modes;
}





public void setModes(List<Mode> modes) {
	this.modes = modes;
}





public int getDose() {
	return dose;
}





public void setDose(int dose) {
	this.dose = dose;
}





public String getItemid() {
	return itemid;
}





public void setItemid(String itemid) {
	this.itemid = itemid;
}





public Order getOrder() {
	return order;
}





public void setOrder(Order order) {
	this.order = order;
}
}
package com.eugene.hospitalmanagementsystem.models;

import java.util.List;

public class addDrug {
	private List <Drug> druglist;
	private List<Mode> modelist;
	private List<Frequency>frequencylist;
	private Order order;
	private int dose;
	private String orderitemid;
	private int duration;
	
	private String drugidentity;
	private String modeid;
	private String frequencyname;
	public String ordernumber;






	public addDrug() {}
	public addDrug(List<Drug> druglist, List<Mode> modelist, List<Frequency> frequencylist, Order order ) {
		
		this.druglist=druglist;
		this.modelist=modelist;
		this.frequencylist=frequencylist;
		this.order=order;
		
	}
	public List<Drug> getDruglist() {
		return druglist;
	}
	public void setDruglist(List<Drug> druglist) {
		this.druglist = druglist;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public String getDrugidentity() {
		return drugidentity;
	}
	public void setDrugidentity(String drugidentity) {
		this.drugidentity = drugidentity;
	}
	public String getOrdernumber() {
		return ordernumber;
	}
	public void setOrdernumber(String ordernumber) {
		this.ordernumber = ordernumber;
	}
	public List<Mode> getModelist() {
		return modelist;
	}
	public void setModelist(List<Mode> modelist) {
		this.modelist = modelist;
	}
	public String getModeid() {
		return modeid;
	}
	public void setModeid(String modeid) {
		this.modeid = modeid;
	}
	public List<Frequency> getFrequencylist() {
		return frequencylist;
	}
	public void setFrequencylist(List<Frequency> frequencylist) {
		this.frequencylist = frequencylist;
	}
	public String getFrequencyname() {
		return frequencyname;
	}
	public void setFrequencyname(String frequencyname) {
		this.frequencyname = frequencyname;
	}
	public int getDose() {
		return dose;
	}
	public void setDose(int dose) {
		this.dose = dose;
	}
	public String getOrderitemid() {
		return orderitemid;
	}
	public void setOrderitemid(String orderitemid) {
		this.orderitemid = orderitemid;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	
	
}

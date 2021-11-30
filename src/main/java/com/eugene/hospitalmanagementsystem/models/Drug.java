package com.eugene.hospitalmanagementsystem.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;
@Component
@Entity
@Table(name="drugs")
public class Drug {
	@Column(name="quantity")
	private int quantity;
	@Column(name="drugname")
	private String drugname;
	private String strength;
	@Id
	@Column(name="drugidentity")
	private String drugidentity;
	private int unitprice;
	
	
	
	
	
	public Drug() {
		
	}
	public Drug(int quantity, String drugname, String strength, String drugidentity,int unitprice) {
		
		this.quantity = quantity;
		this.drugname = drugname;
		this.strength = strength;
		this.drugidentity = drugidentity;
		this.unitprice= unitprice;
	}
	
	
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getDrugname() {
		return drugname;
	}
	public void setDrugname(String drugname) {
		this.drugname = drugname;
	}
	public String getStrength() {
		return strength;
	}
	public void setStrength(String strength) {
		this.strength = strength;
	}
	public String getDrugidentity() {
		return drugidentity;
	}
	public void setDrugidentity(String drugidentity) {
		this.drugidentity = drugidentity;
	}
	public int getUnitprice() {
		return unitprice;
	}
	public void setUnitprice(int unitprice) {
		this.unitprice = unitprice;
	}
	
	
}

package com.eugene.hospitalmanagementsystem.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;
@Component
@Entity
@Table(name="bills")
public class bill {
	@OneToOne
	@JoinColumn(name="usernumber")
	private User user;
	
 @Id
 @Column(name="billnumber")
private String billnumber;

 @ManyToOne (fetch=FetchType.LAZY)
@JoinColumn(name="patientnumber")
private Patient patient;
 
@ManyToMany(fetch=FetchType.LAZY, cascade = CascadeType.ALL)
 @JoinTable(name="bill_items", joinColumns={@JoinColumn(name="billnumber")}, inverseJoinColumns= {@JoinColumn(name="identity")})
	private List<Item> items=new ArrayList<>();
	
@DateTimeFormat(pattern="yyyy-MM-dd")
@Column(name="date")
private Date date;

@Transient
private int billtotal;

@Transient
private String patientid;
	
	
	
	
	
	
	
	
	
	public bill() {
		
	}
	public bill(Date date, Patient patient) {
	
		this.date = date;
		this.patient = patient;
	}
	
	public void additem(Item item) {items.add(item);}
	
	public String getBillnumber() {
		return billnumber;
	}
	
	
	public int getBilltotal() {
		return billtotal;
	}
	public void setBilltotal(int billtotal) {
		this.billtotal = billtotal;
	}
	public void setBillnumber(String billnumber) {
		this.billnumber = billnumber;
	}
	public Patient getPatient() {
		return patient;
	}
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	public List<Item> getItems() {
		return items;
	}
	public void setItems(List<Item> items) {
		this.items = items;
	}
		
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getPatientid() {
		return patientid;
	}
	public void setPatientid(String patientid) {
		this.patientid = patientid;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	
	
}
